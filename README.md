# 🛒 校园二手交易平台 · 开发日志

> 一个面向校园的二手闲置交易平台，从 0 到 1 的完整开发记录：选型、实现、踩坑、加固、上线。

**🔗 在线访问**：[https://taohuo.hsyz.online](https://taohuo.hsyz.online)

![部署-Vercel](https://img.shields.io/badge/部署-Vercel-000000?logo=vercel&logoColor=white)
![数据库-Neon](https://img.shields.io/badge/数据库-Neon%20PostgreSQL-00c4b8?logo=postgresql&logoColor=white)
![实时通信-Ably](https://img.shields.io/badge/实时通信-Ably-00b8d9)
![存储-阿里云OSS](https://img.shields.io/badge/存储-阿里云%20OSS-ff6a00?logo=alibabacloud&logoColor=white)
![认证-JWT](https://img.shields.io/badge/认证-JWT-000000?logo=jsonwebtokens&logoColor=white)

</div>

---

## 📑 目录

- [一、项目简介](#一项目简介)
- [二、技术栈](#二技术栈)
- [三、功能清单](#三功能清单)
- [四、开发阶段与里程碑](#四开发阶段与里程碑)
- [五、关键实现细节](#五关键实现细节)
- [六、踩坑记录与解决](#六踩坑记录与解决)
- [七、安全设计汇总](#七安全设计汇总)
- [八、部署与运维](#八部署与运维)
- [九、后续计划](#九后续计划)

---

## 🎯 一、项目简介

一个面向校园的二手闲置交易平台，支持 **商品发布 → 商品广场 → 商品详情 → 实时聊天 → 消息中心** 的完整闭环。用户可发布书籍、电子产品、日用品、食物等闲置物品，买家浏览后通过内置聊天与卖家实时沟通。

> 📄 更详细的部署与配置说明见 [README](../README.md)。

## 🧱 二、技术栈

| 分层     | 技术                                                                                        | 说明                                               |
| -------- | ------------------------------------------------------------------------------------------- | -------------------------------------------------- |
| 前端     | 原生 HTML / CSS / JS（[index.html](../index.html)、[goods.html](../goods.html) 等）         | 无框架依赖，轻量、部署简单                         |
| 后端     | [Express](https://expressjs.com/zh-cn/)（[Vercel](https://vercel.com) Serverless Function） | 单文件 API 网关：[`api/index.js`](../api/index.js) |
| 数据库   | [Neon](https://neon.tech)（PostgreSQL，Serverless）                                         | 商品、账户、会话、消息持久化                       |
| 实时通信 | [Ably](https://ably.com)（Pub/Sub + Chat SDK + Token 鉴权）                                 | 聊天消息、在线状态、新消息推送                     |
| 图片存储 | [阿里云 OSS](https://www.aliyun.com/product/oss)（STS 临时凭证直传）                        | 浏览器直传，服务端只签发签名                       |
| 认证     | [JWT](https://jwt.io)（HS256，7 天有效期）                                                  | 无状态会话，服务端只信任 token                     |

## ✨ 三、功能清单

- 🔐 **注册 / 登录 / 重置密码**：学号 + 手机号 + 年级班级注册，密码 bcrypt 加密，JWT 登录，支持"记住我"（[`js/auth.js`](../js/auth.js)）。
- 📤 **商品发布**：分类、预估价、描述、多图上传；前端 Canvas 压缩（70% 质量）后再直传 OSS（[`js/publish.js`](../js/publish.js)、[`js/oss-upload.js`](../js/oss-upload.js)）。
- 🏬 **商品广场**：分类筛选、关键词搜索、排序，实时更新统计看板；登录后自动隐藏自己发布的商品（[`js/goods.js`](../js/goods.js)）。
- 🖼️ **商品详情**：多图预览、卖家信息、"联系卖家"一键发起会话（[`js/goods-detail.js`](../js/goods-detail.js)）。
- 📦 **我的发布**：商品管理，支持上下架切换、修改预估价。
- 💬 **实时聊天**：Ably Chat SDK 一对一聊天，历史消息持久化，未读消息小红点，消息中心会话列表（[`js/chat.js`](../js/chat.js)、[`js/notification.js`](../js/notification.js)、[`js/ably-manager.js`](../js/ably-manager.js)）。
- 📢 **管理员能力**：管理员上线全局通报横幅（[`js/admin-banner.js`](../js/admin-banner.js)）。
- 🎨 **辅助功能**：赞助按钮、页面转场动画、敏感内容过滤（[`js/sponsor.js`](../js/sponsor.js)、[`js/page-transitions.js`](../js/page-transitions.js)、[`js/content-filter.js`](../js/content-filter.js)）。

## 🗺️ 四、开发阶段与里程碑

| #   | 阶段        | 内容                                                     |
| --- | ----------- | -------------------------------------------------------- |
| 1   | 🏗️ 骨架搭建 | HTML 页面 + 通用样式 + 页面转场动效，确定整体视觉风格    |
| 2   | 🔐 认证体系 | 注册/登录/重置密码 + JWT 签发与校验 + 前后端双向校验     |
| 3   | 📦 商品链路 | OSS 直传签名 → 发布商品 → 广场列表 → 详情 → 我的发布管理 |
| 4   | 💬 实时聊天 | Ably 集成 → 会话创建/复用 → 消息收发 → 未读标记          |
| 5   | 🛡️ 安全加固 | 登录/注册/会话限流、图片来源校验、CORS 白名单、内容过滤  |
| 6   | 🚀 部署上线 | Vercel + Neon + 自定义域名，接入 Vercel Analytics        |

## 🔍 五、关键实现细节

### 5.1 认证与安全

- 服务端身份**一律以 JWT 为准**，不信任前端提交的 `student_id` / `username` / `sender_id` / `buyer_id`。
- 登录、注册、重置密码、创建会话均做了**基于数据库的限流**（`auth_attempts` 表），按学号 / IP / 手机号维度计数，窗口过期自动重置，适配 Serverless 无内存态。
- 商品图片 URL 校验必须来自受信任的 OSS 域名，防止注入任意外链。
- CORS 采用**手动白名单反射**，兼容 `file://` 的 `null` origin 与本地开发。

### 5.2 OSS 直传

- 服务端通过 **RAM 角色 AssumeRole 获取 STS 临时凭证**，签发 OSS4-HMAC-SHA256 签名。
- 上传目录按用户隔离（`products/<学号>/`），policy 限制 `Content-Type` 必须为图片、单文件 ≤ 10MB。
- 前端先 Canvas 压缩（<100KB 跳过）再直传，降低存储与带宽成本。

### 5.3 实时聊天

- 使用 [`@ably/chat`](https://github.com/ably/ably-chat-js)（Chat SDK）实现房间级聊天，后端 [`/api/chat/token`](../api/index.js) 签发**最小权限 capability**：只授权用户参与过的会话 channel + 用户专属通知频道 + 全局管理员频道。
- 会话创建时校验卖家归属（`publisher_student_id` 比对，历史数据为空则通过用户名反查兜底）。
- 新会话 / 新消息通过 `chat:user:<id>` 频道实时推送，未读计数基于 `conversation_reads` 表计算。

## 🐛 六、踩坑记录与解决

> 💡 这些是开发过程中最值得沉淀的坑，均已在代码中修复。

<details>
<summary><b>1️⃣ Ably importmap 加载失败（ESM 命名导出）</b></summary>

**现象**：`esm.sh` / `jsdelivr+esm` / `esm.run` 转换的 `ably` 只有 default 导出，`@ably/chat` 内部 `import { ErrorInfo } from 'ably'` 报错。

**解决**：importmap 中 `ably` 改用 **data: URL 内联 shim**，从 default 导出补命名导出；且版本必须 ≥ 2.9.0（`@ably/chat@0.7.0` 依赖 ably@2.9.0，2.6.4 会报 `Invalid channel mode: ANNOTATION_PUBLISH`）。

</details>

<details>
<summary><b>2️⃣ `file://` 下动态 `import()` 本地 ESM 被 CORS 拦截</b></summary>

本地直接打开 HTML 时无法 import 本地 shim 文件，最终采用 data: URL 方案规避。

</details>

<details>
<summary><b>3️⃣ Chat SDK 底层 channel 命名</b></summary>

`rooms.get('chat:conversation:<id>')` 底层实际 channel 是 **`chat:conversation:<id>::$chat`**，事件名是 **`chat.message`** 而非 `message`；后端 token capability 必须同时授权 `::$chat` 后缀版本，否则订阅/发布被拒。

</details>

<details>
<summary><b>4️⃣ 低层订阅与 Chat SDK 抢占 channel 冲突</b></summary>

无 importmap 页面（index/goods/publish）用低层 `channels.get`，有 importmap 页面（chat/goods-detail）用 Chat SDK room；先低层占 channel 后再创建 room 会报 `Channels.get() cannot be used to set channel options that would cause the channel to reattach`。解决：按页面类型统一订阅方式，`AblyManager.joinRoom` 增加 `joinedRooms` 缓存复用。

</details>

<details>
<summary><b>5️⃣ `student_id` 是 bigint 的类型陷阱</b></summary>

`accounts.student_id` 为数字类型，后端返回数字导致 JWT / Ably / 数据库比较连环报错（`clientId must be a string`、`TEXT = bigint`）。

**解决**：登录/注册返回时统一 `String(student_id)`；前端判定登录态只用"非空"不用 `typeof === 'string'`。

</details>

<details>
<summary><b>6️⃣ `conversations.product_id`（TEXT）JOIN 商品表（UUID）类型不匹配</b></summary>

直接 JOIN 报 `operator does not exist: text = uuid`，必须写 `ON c.product_id = p.id::text`。

</details>

<details>
<summary><b>7️⃣ 登录信息存储键名错误</b></summary>

曾误读 `localStorage.getItem('user')`，但存储键实际是 `userLoginInfo`，导致已登录也被判为未登录；统一改为通过 `window.getLoginInfo()` 读取（见 [`js/utils.js`](../js/utils.js)）。

</details>

## 🛡️ 七、安全设计汇总

- ⏱️ **限流**：登录 5 次/15min（按学号）、10 次/15min（按 IP）；注册 10 次/小时（按 IP）；重置密码、创建会话同理。
- 🙈 **防枚举**：登录失败统一返回"学号或密码不正确"，不区分账号是否存在。
- 🔒 **越权防护**：商品 PATCH、会话消息、已读标记均校验归属与参与关系。
- 🧹 **内容安全**：上传白名单图片类型 + 图片域名校验；内容过滤模块兜底。
- 🗄️ **数据库访问**：全链路参数化查询（`sql` 模板），无字符串拼接注入面。

## 🚀 八、部署与运维

- 🌐 **访问域名**：[`taohuo.hsyz.online`](https://taohuo.hsyz.online)（Vercel 自定义域名绑定，生产环境通过该域名访问）。
- ⚙️ **Vercel**：[`vercel.json`](../vercel.json) 配置 `/api/*` rewrite 到 Serverless Function；静态资源同域部署。
- 🔑 **环境变量**：`DATABASE_URL`、`JWT_SECRET`、`ABLY_API_KEY`、`OSS_BUCKET`、`OSS_REGION`、`ALIBABA_CLOUD_*`、`ALLOWED_ORIGINS`。
- 🗄️ **数据库迁移**：`.vscode/sql/` 目录下幂等建表 + 历史数据回填脚本（[`create_chat_tables.sql`](../.vscode/sql/create_chat_tables.sql)、[`ensure_publisher_student_id.sql`](../.vscode/sql/ensure_publisher_student_id.sql)、[`backfill_publisher_student_id.sql`](../.vscode/sql/backfill_publisher_student_id.sql)、[`add_conversation_reads.sql`](../.vscode/sql/add_conversation_reads.sql)）。
- 📊 **分析统计**：接入 Vercel Web Analytics（`/_vercel/insights/script.js`），按自定义域名统计真实流量。

## 📌 九、后续计划

- [ ] 💖 商品收藏 / 点赞功能
- [ ] ⭐ 卖家信誉评价体系
- [ ] 🖼️ 图片懒加载与缩略图 CDN
- [ ] 🛠️ 后台管理面板（用户/商品/举报审核）
- [ ] 📱 移动端 PWA 支持


