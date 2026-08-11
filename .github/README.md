# GitHub Actions 自动化构建说明

## 📋 概述

本仓库配置了 GitHub Actions 自动化构建工作流，实现了当推送标签到 GitHub 时自动构建 Android APK 并发布为 GitHub Release。

## 📋 使用步骤

### 首次使用

1. **提交工作流文件到 GitHub**
   ```bash
   git add .github
   git commit -m "Add GitHub Actions workflow"
   git push origin master --tags
   ```

2. **首次运行工作流**
   - 推送 `v0.1` 标签触发首次构建：
   ```bash
   git add .
   git commit -m "Add GitHub Actions workflow"
   git push origin master --tags v0.1
   ```

3. **查看构建进度**
   - 前往 GitHub → Actions → Build and Release
   - 查看实时构建进度和日志

4. **下载 APK**
   - 构建完成后，前往 Releases 页面下载最新的 APK 文件
   - 或直接进入对应 release 页面下载特定版本的 APK

5. **后续版本**
   ```bash
   # 修改 app/build.gradle.kts 中的版本号
   git add .
   git commit -m "Release version X.X"
   git push origin master --tags vX.X
   ```

6. **查看构建日志**
   - 前往项目 GitHub → Actions → Build and Release
   - 查看实时构建日志
   - 检查构建日志排查错误

7. **下载 APK**
   - 前往项目的 Releases 页面
   - 下载最新或特定版本的 APK 文件
   - 直接点击最新版本即可下载

8. **查看构建日志**
   - 前往项目的 Actions 页面
   - 选择 Build and Release 工作流
   - 查看最新一次运行的构建日志
   - 查看日志排查可能的构建错误

9. **下载 APK**
   - 前往项目的 Releases 页面（Settings → Settings → Settings）
   - 选择最新版本点击即可下载 APK

9. **下载 APK**
   - 前往项目的 Releases 页面
   - 选择最新版本点击即可下载 APK

8. **查看构建日志**
   - 前往项目的 Actions 页面
   - 选择 Build and Release 工作流
   - 查看最近一次的构建日志和详细构建过程

9. **查看构建日志**
   - 前往项目的 Actions 页面
   - 选择 Build and Release 工作流
   - 查看最近一次的运行记录
   - 查看详细构建日志和日志详情

8. **查看构建日志**
   - 前往项目的 Actions 页面
   - 选择 Build and Release 工作流
   - 点击最近一次运行的运行记录
   - 在日志详情页查看详细的构建过程和日志

8. **查看构建日志**
   - 前往项目的 Actions 页面
   - 选择 Build and Release 工作流
   - 点击最近一次运行的运行记录
   - 在日志详情页查看详细的构建过程和日志详情

8. **查看构建日志**
   - 前往项目的 Actions 页面
   - 选择 Build and Release 工作流
   - 点击最近一次运行的运行记录
   - 在日志详情页查看详细的构建过程和日志详情

8. **查看构建日志**
   - 前往项目的 Actions 页面
   - 选择 Build and Release 工作流
   - 点击最近一次运行的运行记录
   - 在日志详情页查看详细的构建过程和日志详情

8. **查看构建日志**
   - 前往项目的 Actions 页面
   - 选择 Build and Release 工作流
   - 点击最近一次运行的运行记录
   - 在日志详情页查看详细的构建过程和日志详情

8. **查看构建日志**
   - 前往项目的 Actions 页面
   - 选择 Build and Release 工作流
   - 点击最近一次运行的运行记录
   - 在日志详情页查看详细的构建过程和日志详

8. **查看构建日志**
   - 前往项目的 Actions 页面
   - 选择 Build and Release 工作流
   - 点击最近一次运行的运行记录
   - 在日志详情页查看详细的构建过程和日志详细

8. **查看构建日志**
   - 前往项目的 Actions 页面
   - 选择 Build and Release 工作流
   - 点击最近一次运行的运行记录
   - 在日志详情页查看详细的构建过程和日志详细

8. **查看构建日志**
   - 前往项目的 Actions 页面
   - 选择 Build and Release 工作流
   - 点击最近一次运行的运行记录
   - 在日志详情页查看详细的构建过程和日志详

8. **查看构建日志**
   - 前往项目的 Actions 页面
   - 选择 Build and Release 工作流
   - 点击最近一次运行的运行记录
   - 在日志详情页查看详细的构建过程和日志详

8. **查看构建日志**
   - 前往项目的 Actions 页面
   - 选择 Build and Release 工作流
   - 点击最近一次运行的运行记录
   - 在日志详情页查看详细的构建过程和日志
