<h2>注意： Hexo Boot 4.0 版本项目代码结构大调整</h2>
<h3>调整内容看下文第七点</h3>

## 一、Hexo Boot

Hexo Boot 是基于 Spring Boot + MySQL 开发的一套开源的博客系统。前身是 [ml-blog](https://github.com/moonlightL/ml-blog) 博客系统，在此基础上演变和扩展而来。

[![](https://img.shields.io/badge/license-MIT-brightgreen.svg)](https://github.com/moonlightL/ml-blog/blob/master/LICENSE)
![](https://img.shields.io/badge/language-Java-blue.svg)

## 二、扩展功能

除了继承 [ml-blog](https://github.com/moonlightL/ml-blog) 中的功能（文章、分类、标签、全局参数）外，Hexo Boot 还扩展了一下功能

### 2.1 评论、留言功能

```
轻松查看网友的评论与留言，及时互动，同时还附带表情功能，丰富回复内容
```

### 2.2 友链功能

```
与网友互换主页，友好分享
```

### 2.3 主题功能

```
支持前端页面主题动态变换以及在线编辑源码，让页面色彩丰富起来，同时支持自定义主题
```

### 2.4 黑名单功能

```
设置 ip 黑名单，防御网络小人恶意攻击系统
```

### 2.5 附件功能

```
支持本地、七牛云、OSS、COS 4种对象存储方式
```

### 2.6 备份功能

```
支持自动和手动备份SQL数据，防患数据丢失
```

### 2.7 音乐播放

```
支持音乐配置管理以及在线播放，切换页面不中断
```

### 2.8 动态

```
发表个人心情（支持图片、视频和 emoji 表情）、名人名言等简短信息
```

### 2.9 默认主题特色

```
支持 CDN 配置
图片延迟加载
图片灯箱
夜间模式
音乐播放
打赏功能
点赞功能
评论功能（支持两种：默认和Twikoo）
文章布局（支持两种：卡片和列表）
实现 pjax 
```

更多详情请访问下边提供的网址进行浏览。

### 2.10 插件管理

```
支持模块化功能开发，模块热插拔，实现功能定制化（4.0版本新增）
```

## 三、预览效果

[网站演示1（默认主题）](https://www.liuyj.top/) 

[网站演示2（默认主题）](https://wno704.top/) 

[网站演示3（私人订制）](https://www.extlight.com/) 


### 3.1 后台管理预览图

![安装页面](https://images.extlight.com/hexo-boot-00.jpg)

![仪表盘页面](https://images.extlight.com/hexo-boot-01.jpg)

![文章页面](https://images.extlight.com/hexo-boot-02.jpg)

![评论页面](https://images.extlight.com/hexo-boot-03.jpg)

![参数配置页面](https://images.extlight.com/hexo-boot-04.jpg)

![个人详情页面](https://images.extlight.com/hexo-boot-05.jpg)

![数据备份页面](https://images.extlight.com/hexo-boot-06.jpg)

![黑名单页面](https://images.extlight.com/hexo-boot-07.jpg)

![附件页面](https://images.extlight.com/hexo-boot-08.jpg)

![主题列表页面](https://images.extlight.com/hexo-boot-09.jpg)

![修改主题源码页面](https://images.extlight.com/hexo-boot-10.jpg)

### 3.2 前端预览图(默认主题)

![](https://images.extlight.com/hexo-boot-theme-default.jpg)

## 四、启动与部署

### 4.1 启动

下载源码，通过 Idea 工具打开项目，修改 resources 目录下的 application.yml 中的数据库配置（用户名和密码），运行项目即可。

前端主页访问地址： 
```
http://127.0.0.1:8080
```

后端管理访问地址
```
http://127.0.0.1:8080/admin/login.html
```

**注意：首次访问上边的链接会自动跳转到安装页面，填写好相关用户信息，点击安装即可。**

### 4.2 部署

该项目支持 war 包和 jar 包两种方式运行

#### 4.2.1 war 包形式

1.修改 pom.xml 文件的 2 处地方：

```
将 <packaging>war</packaging> 注释放开

排除 spring-boot-starter-web 的内置 tomcat
```

2.``mvn clean package``，打出名为 ROOT.war 文件，将其上传至 tomcat 的 webapps 目录下（如已有 ROOT 文件，将其删掉），启动 tomcat 即可

#### 4.2.2 jar 包形式

1.创建博客配置文件夹 ``mkdir ~/.hexo-boot``

2.mvn clean package，打出 jar 包后上传至 **~/.hexo-boot**

3.将 application.yml 文件上传至 **~/.hexo-boot** 目录中，根据自己的情况修改**application.yml**的数据库信息

4.创建 Service 服务

```
vim /etc/systemd/system/hexo-boot.service

# 编辑内容如下：

[Unit]
Description=hexo-boot
After=syslog.target

[Service]
User=root
ExecStart=/usr/java/jdk8/bin/java -server -Xms512m -Xmx1024m -jar /root/.hexo-boot/hexo-boot.jar --spring.config.additional-location=/root/.hexo-boot/
Restart=always

[Install]
WantedBy=multi-user.target
```

**注意：内存分配和路径根据自己的情况进行修改，且路径必须是绝对路径！**

**注意：内存分配和路径根据自己的情况进行修改，且路径必须是绝对路径！**

**注意：内存分配和路径根据自己的情况进行修改，且路径必须是绝对路径！**

5. 服务命令

```
# 启动
systemctl start hexo-boot
# 重启
systemctl restart hexo-boot
# 关闭
systemctl stop hexo-boot
```

6. 补充

步骤1 和 步骤2 可以使用如下命令代替

**注意 jar 版本号，请使用最新版本**

**注意 jar 版本号，请使用最新版本**

**注意 jar 版本号，请使用最新版本**

【GitHub】资源

```
# 下载安装包
curl -L https://github.com/moonlightL/hexo-boot/releases/download/2.3/hexo-boot-2.3.0.jar --output ~/.hexo-boot/hexo-boot.jar

# 下载 spring boot 配置文件，记得要修改数据库配置
curl -L -o ~/.hexo-boot/application.yml --create-dirs https://github.com/moonlightL/hexo-boot/releases/download/1.4.0/application.yml
```

【码云】资源

```
# 下载安装包
curl -L https://gitee.com/moonlightL/hexo-boot/attach_files/620620/download/hexo-boot-2.3.0.jar --output ~/.hexo-boot/hexo-boot.jar

# 下载 spring boot 配置文件，记得要修改数据库配置
curl -L -o ~/.hexo-boot/application.yml --create-dirs https://gitee.com/moonlightL/hexo-boot/attach_files/537532/download/application.yml
```

## 五、添加主题

### 5.1 方式一

下载主题源码，修改名称（比如 hexo-boot-theme-abc 改成 abc），然后将整个文件夹复制到项目的 resources/templates/theme 下（与 default 目录同级），启动项目即可。

如若项目已经启动运行，也可复制到 classes/templates/theme 下即可

### 5.2 方式二

进入博客后端管理界面 -> 更换主题 -> 拉取安装，出现地址拉取框

输入主题的 git 地址，点击“拉取”按钮，即可等待下载安装

### 5.3 方式三

将主题文件(.zip)下载到本地，然后进入博客后端管理界面 -> 更换主题 -> 上传安装，出现上传文件框

选择需要上传的主题文件，点击“解压安装”按钮即可

**目前已开源的主题:**

[hexo-boot-theme-vCard](https://github.com/moonlightL/hexo-boot-theme-vCard)

[hexo-boot-theme-breezyCV](https://github.com/moonlightL/hexo-boot-theme-breezyCV)

[hexo-boot-theme-next](https://github.com/moonlightL/hexo-boot-theme-next)

[hexo-boot-theme-wuxia](https://github.com/moonlightL/hexo-boot-theme-wuxia)

如果网络不佳，无法访问 GitHub，也可以访问 [码云](https://gitee.com/moonlightL) ，找到主题进行下载。

### 5.3 自定义主题

篇幅较大，请查看 Wiki

[GitHub Wiki](https://github.com/moonlightL/hexo-boot/wiki/%E8%87%AA%E5%AE%9A%E4%B9%89%E4%B8%BB%E9%A2%98)

[码云 Wiki](https://gitee.com/moonlightL/hexo-boot/wikis/%E8%87%AA%E5%AE%9A%E4%B9%89%E4%B8%BB%E9%A2%98?sort_id=3151185)

## 六、更新日志

2022-04-04 整合 COS（腾讯云）对象存储，优化文件上传代码

2022-02-18 统一评论功能接口，重写评论区插件

2021-12-23 新增发布专辑功能（图片、视频）

2021-07-08 新增日志记录功能

2021-06-29 文章添加访问密码

2021-06-24 新增动态功能

2021-06-22 新增自定义文章链接，支持上传zip包安装博客主题

2021-04-28 新增富文本编辑器（已支持 editor.md 和 summernote 两套编辑器）

2021-03-24 实现 html 内容压缩渲染

2021-03-03 调整管理后台主题源码修改编辑区，新增代码高亮、关键字查询和行数定位功能

2021-02-03 默认主题支持 pjax 请求，同时新增音乐播放功能

2020-12-16 调整默认主题，新增自定义页面功能

2020-12-02 支持 jar 方式部署运行

2020-11-12 新增在线下载拉取主题功能

2020-10-30 扩展主题配置，在线编辑主题文件，调整评论区插件的展示列表

2020-10-22 上传开源

## 七、Hexo-Boot 4.0 版本调整

* 代码结构分层
* 新增插件功能
* 将 druid 数据源替换为 HikariCP
* 抽离系统信息代码，以插件形式封装
* 抽离第三方对象存储代码，以插件形式封装