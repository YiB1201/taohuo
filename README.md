# 淘货 (Taohuo)

一款功能完善的 Android 二手交易平台应用，提供商品发布、即时通讯、收藏管理等功能。

## 📱 项目简介

淘货是一款基于 Android 平台的移动端购物应用，支持用户浏览商品、发布商品、实时聊天沟通、收藏管理等核心功能。应用采用前后端分离架构，通过 RESTful API 与后端服务通信，集成 Ably 实现跨平台实时通信（与网页端互通）。

## ✨ 核心功能

### 1. 用户认证
- 登录/注册功能
- 密码明文切换（小眼睛图标）
- 登录状态管理
- 匿名浏览支持

### 2. 商品管理
- **发布商品**: 多图上传、价格输入、商品描述
- **商品列表**: 网格布局展示，下拉刷新
- **商品详情**: 详细信息展示，图片轮播预览
- **图片选择**: 自定义多图选择器，支持预览和删除
- **已售状态**: 自动同步商品状态
- **我发布的**: 查看自己发布的所有商品
- **我的收藏**: 收藏/取消收藏商品

### 3. 实时聊天
- **即时通讯**: 基于 Ably 的实时消息收发
- **跨平台互通**: 与网页端 ably-js 消息互通
- **离线缓存**: 网络恢复后自动同步消息
- **会话管理**: 会话列表、删除会话
- **未读提示**: 消息未读数角标
- **屏蔽词**: 敏感词过滤功能

### 4. 通知系统
- **系统通知**: 新消息推送通知
- **桌面角标**: 多厂商适配（华为、荣耀、三星、OPPO、vivo 等）
- **点击跳转**: 通知点击直达聊天页面
- **保活服务**: 前台服务维持连接

### 5. UI/UX
- **主题切换**: 黑色/白色背景应用图标切换
- **暗黑模式**: 支持系统暗黑模式
- **底部导航**: 广场、发布、消息、我的
- **图片预览**: 全屏浏览，缩放交互
- **动画效果**: 流畅的页面过渡动画

### 6. 应用更新
- **版本检测**: 自动检查最新版本
- **APK 下载**: 应用内下载更新包
- **安装引导**: 调起系统安装器

## 🛠 技术栈

### 开发语言
- Java
- 最低 SDK: 27 (Android 8.1)
- 目标 SDK: 36 (Android 15)
- 编译 SDK: 36 (Android 15)

### 核心依赖

| 依赖 | 版本 | 用途 |
|------|------|------|
| AndroidX AppCompat | 1.6.1 | Android 兼容性库 |
| Material Design | 1.10.0 | Material Design 组件 |
| ConstraintLayout | 2.1.4 | 约束布局 |
| GridLayout | 1.0.0 | 网格布局 |
| Retrofit | 3.0.0 | REST API 客户端 |
| Gson Converter | 3.0.0 | JSON 序列化/反序列化 |
| Glide | 4.16.0 | 图片加载与缓存 |
| Ably | 1.8.0 | 实时通信（WebSocket） |
| Gson | 2.14.0 | JSON 处理 |

### 构建工具
- Gradle 8.x
- Android Gradle Plugin
- ProGuard 代码混淆

## 📂 项目结构

```
taohuo/
├── app/
│   ├── src/main/
│   │   ├── java/com/taohuo/hsyz/
│   │   │   ├── AblyManager.java              # Ably 实时通信管理
│   │   │   ├── ApiClient.java                 # API 客户端封装
│   │   │   ├── AppIconManager.java            # 应用图标切换管理
│   │   │   ├── AppUpdater.java                # 应用更新检测
│   │   │   ├── ChatActivity.java              # 聊天界面
│   │   │   ├── ChatFilter.java                # 聊天屏蔽词过滤器
│   │   │   ├── ChatKeepAliveService.java      # 聊天保活服务
│   │   │   ├── ChatLocalStore.java            # 聊天本地存储
│   │   │   ├── ChatMessage.java               # 聊天消息模型
│   │   │   ├── ChatMessageAdapter.java        # 消息列表适配器
│   │   │   ├── ConversationAdapter.java       # 会话列表适配器
│   │   │   ├── FavoriteProductsActivity.java  # 我的收藏
│   │   │   ├── FavoriteStore.java             # 收藏存储管理
│   │   │   ├── GalleryAdapter.java            # 画廊适配器
│   │   │   ├── ImageAdapter.java              # 图片适配器
│   │   │   ├── ImagePreviewActivity.java      # 图片预览
│   │   │   ├── ImagePagerAdapter.java         # 图片轮播适配器
│   │   │   ├── LauncherBadgeHelper.java       # 桌面角标助手
│   │   │   ├── LoginActivity.java             # 登录界面
│   │   │   ├── LoginManager.java              # 登录状态管理
│   │   │   ├── MainActivity.java              # 主界面
│   │   │   ├── MarketFragment.java            # 商品广场碎片
│   │   │   ├── MessageFragment.java           # 消息碎片
│   │   │   ├── MineFragment.java              # 个人中心碎片
│   │   │   ├── MyProductsActivity.java        # 我发布的商品
│   │   │   ├── NotificationHelper.java        # 通知助手
│   │   │   ├── OssUploader.java               # OSS 文件上传
│   │   │   ├── PickImageFragment.java         # 图片选择碎片
│   │   │   ├── ProductAdapter.java            # 商品适配器
│   │   │   ├── ProductDetailActivity.java     # 商品详情
│   │   │   ├── PublishProductFragment.java    # 发布商品碎片
│   │   │   ├── SettingsActivity.java          # 设置界面
│   │   │   ├── SplashActivity.java            # 启动页
│   │   │   ├── SystemPermissionHelper.java    # 系统权限管理
│   │   │   ├── TaohuoApp.java                 # 应用入口
│   │   │   ├── ThemeModeManager.java          # 主题管理
│   │   │   └── ZoomableImageView.java         # 可缩放图片视图
│   │   │
│   │   ├── res/
│   │   │   ├── drawable/                      # 绘图资源
│   │   │   ├── layout/                        # 布局文件
│   │   │   ├── mipmap-*/                      # 图标资源
│   │   │   ├── values/                        # 字符串、颜色、样式
│   │   │   ├── values-night/                  # 暗黑模式资源
│   │   │   └── xml/                           # XML 配置
│   │   │
│   │   └── AndroidManifest.xml                # 应用清单
│   │
│   └── build.gradle.kts                       # 模块构建配置
│
├── build.gradle.kts                           # 项目构建配置
├── settings.gradle.kts                        # 项目设置
├── gradle.properties                          # Gradle 属性
└── local.properties                           # 本地环境配置
```

## 🔧 快速开始

### 环境要求

- JDK 11 或更高版本
- Android Studio Hedgehog 或更高版本
- Android SDK 36
- Gradle 8.x

### 构建步骤

1. **克隆仓库**
   ```bash
   git clone https://github.com/YiB1201/taohuo.git
   cd taohuo
   ```

2. **打开项目**
   - 启动 Android Studio
   - 选择 `File > Open`
   - 选择项目根目录 `F:\taohuo`

3. **同步 Gradle**
   - Android Studio 会自动同步 Gradle
   - 等待构建完成

4. **运行应用**
   - 连接 Android 设备或启动模拟器
   - 点击运行按钮或按 `Shift + F10`

### 手动构建（命令行）

```bash
# Windows (使用 Gradle Wrapper)
.\gradlew.bat assembleDebug

# 或直接使用系统 Gradle
gradle assembleDebug
```

## 📋 权限说明

### 必需权限

| 权限 | 用途 |
|------|------|
| INTERNET | 网络请求，访问后端 API |
| ACCESS_NETWORK_STATE | 判断网络状态，支持离线缓存 |
| REQUEST_INSTALL_PACKAGES | 应用内下载安装更新包 |

### 运行时权限

| 权限 | 用途 |
|------|------|
| POST_NOTIFICATIONS | 发送消息通知 (Android 13+) |
| READ_MEDIA_IMAGES | 读取图片（Android 13+） |
| READ_EXTERNAL_STORAGE | 读取图片（Android 12 及以下） |

### 角标权限（静默申请）

| 权限 | 厂商 |
|------|------|
| com.huawei...CHANGE_BADGE | 华为/荣耀 |
| com.hihonor...CHANGE_BADGE | 荣耀（MagicOS） |
| com.sec.android...BADGE | 三星 |
| com.oppo...SETTINGS | OPPO/OnePlus/Realme |
| com.vivo...NOTIFICATION | vivo/iQOO |

## 🎨 主要功能流程

### 1. 发布商品流程
```
底部导航 "发布" → 选择图片（多图） → 填写商品信息（名称、描述、价格）
→ 调用 OSS 上传 → 提交后端 API → 刷新商品列表
```

### 2. 聊天通讯流程
```
进入商品详情 → 点击"联系商家" → 打开聊天窗口
→ 发送/接收消息 → Ably 实时推送
→ 消息本地缓存 → 离线时队列存储 → 网络恢复后同步
```

### 3. 收藏商品流程
```
商品详情页 → 点击收藏按钮 → 存入本地数据库
→ 我的收藏页面查看 → 支持取消收藏
```

### 4. 登录流程
```
启动页 → 检查登录状态 → 未登录跳转登录页
→ 输入账号密码 → 调用后端验证 → 保存 Token
→ 启动保活服务 → 进入主界面
```

## 🌐 API 对接

应用通过 `ApiClient` 类统一管理所有后端接口调用：

- **用户认证**: 登录、注册、状态检查
- **商品管理**: 发布、获取列表、更新状态
- **图片上传**: 调用 OSS 预签名 URL
- **聊天功能**: Ably 频道订阅与消息发送
- **收藏管理**: 添加/移除收藏

## 💾 数据存储

### 本地缓存
- **SharedPreferences**: 用户登录状态、设置项
- **SQLite/Room**: 聊天记录、收藏数据
- **文件系统**: 图片缓存、离线数据

### 离线支持
- 消息离线缓存
- 断线重连机制
- 数据同步策略

## 🔐 安全特性

- HTTPS 加密传输
- Token 认证机制
- 敏感词过滤
- ProGuard 代码混淆
- 权限动态申请

## 📱 多厂商适配

### 应用图标
- 黑色背景（默认）
- 白色背景（设置中切换）

### 桌面角标
- 华为/荣耀 EMUI/HarmonyOS
- 荣耀 MagicOS
- 三星 Samsung Experience
- OPPO/OnePlus/Realme ColorOS/OxygenOS
- vivo/iQOO Funtouch OS

### 后台保活
- 前台服务（Foreground Service）
- WakeLock 防休眠
- 电池优化豁免引导
- Ably WebSocket 长连接

## 🚀 版本历史

### v2.3 (当前版本)
- 优化图片选择和预览功能
- 改进聊天消息同步机制
- 新增敏感词过滤功能
- 增强通知和角标显示
- UI 视觉升级
- 主题切换优化

## 📝 开发规范

### 代码风格
- Java CamelCase 命名规范
- 统一的异常处理
- 模块化设计
- 注释清晰完整

### 资源管理
- Drawable 资源精简
- 统一颜色主题
- 响应式布局设计

### 性能优化
- 图片异步加载（Glide 缓存）
- 列表虚拟化（RecyclerView）
- 减少不必要的布局嵌套
- 内存泄漏防护

## 🐛 已知问题

- 部分机型后台连接不稳定（已引导用户开启电池优化豁免）
- 角标显示因厂商限制可能不完全支持

## 📄 License

本项目仅供学习和内部使用。

## 👥 联系方式

- GitHub: [YiB1201/taohuo](https://github.com/YiB1201/taohuo)
- 项目地址: `F:\taohuo`

---

**最后更新**: 2026-08-11
