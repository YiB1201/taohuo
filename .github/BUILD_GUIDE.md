# GitHub Actions 自动化构建说明

## 功能概述

此工作流实现了当推送标签到 GitHub 仓库时，自动构建 Android APK 并发布为 GitHub Release。

## 触发方式

### 1. 自动触发（推荐）
当你推送带有 `v` 前缀的标签时，工作流会自动运行：
```bash
git tag v2.3
git push origin v2.3
```

### 2. 手动触发
在 GitHub 页面的 Actions → Build and Release → Run workflow 手动运行。

## 工作流程

1. **检出代码** - 从 GitHub 仓库获取最新代码
2. **配置 JDK** - 设置 Amazon JDK 23 环境
3. **生成 Gradle Wrapper** - 如果不存在则自动生成
4. **构建 Release APK** - 使用 Gradle 构建发布版本
5. **读取版本号** - 自动从 `app/build.gradle.kts` 读取 versionName 和 versionCode
6. **上传 Artifact** - 将 APK 上传为构建产物（保留30天）
7. **创建 GitHub Release** - 自动创建 Release 并上传 APK

## 版本管理

版本号自动从 `app/build.gradle.kts` 中读取：
```kotlin
defaultConfig {
    versionCode = 1
    versionName = "2.3"
}
```

## 使用步骤

### 第一次使用
1. 将 `.github/workflows/build.yml` 提交到仓库
2. 修改 `app/build.gradle.kts` 中的版本号
3. 打标签并推送：
   ```bash
   git add .
   git commit -m "Update version to 2.3"
   git tag v2.3
   git push origin master --tags
   ```
4. 前往 GitHub → Actions 查看构建进度
5. 构建完成后，在 Releases 页面下载 APK

### 后续版本
```bash
# 修改 app/build.gradle.kts 中的 versionCode 和 versionName
git add .
git commit -m "Release version 2.4"
git tag v2.4
git push origin v2.4
```

## 注意事项

### APK 签名
当前配置未配置签名，生成的 APK 为未签名的 Release 版。如需自动签名，需添加：

```yaml
- name: Sign APK
  uses: r0adkll/sign-android-release@v1
  with:
    releaseDirectory: app/build/outputs/apk/release/
    signingKeyBase64: ${{ secrets.SIGNING_KEY }}
    alias: ${{ secrets.ALIAS }}
    keyStorePassword: ${{ secrets.KEY_STORE_PASSWORD }}
    keyPassword: ${{ secrets.KEY_PASSWORD }}
```

需要在 GitHub Secrets 中配置签名信息（Settings → Secrets and variables → Actions）。

### 版本号规范
- 标签格式：`v` + 版本号（如 `v2.3`, `v1.0.0`）
- versionName 建议遵循语义化版本：主版本号.次版本号.修订号

### 构建失败排查
1. 查看 Actions 页面的构建日志
2. 检查代码是否有编译错误
3. 确认 gradle 依赖是否正确
4. JDK 版本是否与项目匹配

## 自定义 Release 说明

在工作流的 `Create GitHub Release` 步骤中，可以修改 `body` 内容来自定义 Release 说明模板。

## 高级配置

### 添加多架构 APK
```yaml
- name: Build APK with Gradle
  run: |
    chmod +x gradlew
    ./gradlew assembleRelease
```

会生成多个 APK：
- `app-armeabi-v7a-release.apk`
- `app-arm64-v8a-release.apk`
- `app-x86_64-release.apk`

### 添加测试
可以在构建前添加测试步骤：
```yaml
- name: Run Unit Tests
  run: ./gradlew testRelease
```
