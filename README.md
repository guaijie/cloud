## 微服务

### 关键语句
-  a suit of small services：一系列微小的服务共同组成
-  running in its own process：独立运行
-  built around business capabilities：围绕独立业务开发能力
-  independently deployable：独立部署
-  a bare minimum of centralized management of these services：分布式管理

### 微服务的特点
-  异构
    - 不同语言(例如可以使用node的eureka-js-client生成的EurekaClient注册到Java的EurekaServer上去)
    - 不同类型数据库
-  颗粒化
-  独立部署
-  独立业务开发
-  分布式管理

### 架构演进

#### 单体架构
- 优点：
  - 容易测试
  - 容易部署
- 缺点：
  - 开发效率低
  - 代码维护困难
  - 部署不够灵活（小改动要整体部署）
  - 稳定性不高
  - 扩展性不够
  
#### 分布式架构
旨在支持应用程序和服务的开发，可以利用物理架构由 **多个自治的处理元素** ，**不共享主内存**，**但通过网络发送消息合作**。

### Spring Cloud BOM

<ul>
    <li>
        <h4><a href="https://spring.io/projects/spring-cloud-config#learn">Spring Cloud Config</a><h4>
        <p>配置管理开发工具包，可以让你把配置放到远程服务器，目前支持本地存储、Git以及Subversion，保证某些隐私信息的安全，同时可结合spring cloud bus实现实时刷新。</p>
    </li>
    <li>
        <h4><a href="https://spring.io/projects/spring-cloud-netflix#learn">Spring Cloud Netflix</a><h4>
        <p>将Netflix公司OSS组件整合进spring cloud中，其中包括：</p>
        <ul>
            <li>
                <h4>archaius</h4>
                <p>配置管理API，包含一系列配置管理API，提供动态类型化属性、线程安全配置操作、轮询框架、回调机制等功能。</p>
            </li>
            <li>
                <h4>eureka</h4>
                <p>云端负载均衡，一个基于 REST 的服务，用于定位服务，以实现云端的负载均衡和中间层服务器的故障转移。</p>
            </li>
            <li>
                <h4>hystrix</h4>
                <p>容错管理工具，旨在通过控制服务和第三方库的节点,从而对延迟和故障提供更强大的容错能力。</p>
            </li>
            <li>
                <h4>ribbon</h4>
                <p></p>
            </li>
            <li>
                <h4>turbine</h4>
                <p></p>
            </li>
            <li>
                <h4>zuul</h4>
                <p>边缘服务工具，是提供动态路由，监控，弹性，安全等的边缘服务。</p>
            </li>
        </ul>
    </li>
    <li>
        <h4><a href="https://spring.io/projects/spring-cloud-bus#learn">Spring Cloud Bus</a><h4>
        <p>事件、消息总线，用于在集群（例如，配置变化事件）中传播状态变化，可与Spring Cloud Config联合实现热部署。</p>
    </li>  
    <li>
        <h4><a href="https://spring.io/projects/spring-cloud-consul#learn">Spring Cloud Consul</a><h4>
        <p>封装了Consul操作，consul是一个服务发现与配置工具，与Docker容器可以无缝集成。</p>
    </li>     
    <li>
        <h4><a href="https://spring.io/projects/spring-cloud-gateway#learn">Spring Cloud Gateway</a><h4>
        <p>由spring mvc开发组构建的基于spring mvc之上的API网关组件。</p>
    </li>     
    <li>
        <h4><a href="https://spring.io/projects/spring-cloud-sleuth#learn">Spring Cloud Sleuth</a><h4>
        <p>用于链路追踪和服务定位，可快速定位到服务故障点，封装了Dapper,Zipkin和HTrace操作。</p>
    </li>  
    <li>
        <h4><a href="https://spring.io/projects/spring-cloud-security#learn">Spring Cloud Security</a><h4>
        <p>安全工具包，为你的应用程序添加安全控制，主要是指OAuth2。</p>
    </li>  
    <li>
        <h4><a href="https://spring.io/projects/spring-cloud-dataflow#learn">Spring Cloud Data Flow</a><h4>
        <p>大数据操作工具，通过命令行方式操作数据流。</p>
    </li>  
    <li>
        <h4><a href="https://spring.io/projects/spring-cloud-zookeeper#learn">Spring Cloud Zookeeper</a><h4>
        <p>操作Zookeeper的工具包，用于使用zookeeper方式的服务注册和发现。</p>
    </li>  
    <li>
        <h4><a href="https://spring.io/projects/spring-cloud-stream#learn">Spring Cloud Stream</a><h4>
        <p>数据流操作开发包，封装了与Redis,Rabbit、Kafka等发送接收消息。</p>
    </li>  
    <li>
        <h4><a href="https://github.com/spring-cloud/spring-cloud-cli">Spring Cloud CLI</a><h4>
        <p>基于 Spring Boot CLI，可以让你以命令行方式快速建立云组件。</p>
    </li> 
    <li>
        <h4><a href="https://cloud.spring.io/spring-cloud-cloudfoundry/">Spring Cloud Cloudfoundry</a><h4>
        <p>通过Oauth2协议绑定服务到CloudFoundry，CloudFoundry是VMware推出的开源PaaS云平台。</p>
    </li>  
</ul>

### 微服务架构的基础架构/组件
1. 服务注册发现(服务间通信)
  - 服务的提供方：注册
  - 服务的调用方：发现
2. 服务网关(Service Gateway)(前后端通信)
  - 屏蔽细节
  - 路由
  - 限流和容错
  - 请求拦截
3. 后端通用服务(中间层服务Middle Tier Service)
> 启动后将地址信息注册到服务注册表中
4. 前端(边缘服务Edge Service)
> 查询服务注册表发现和调用后端服务，它主要是对后端服务做必要的**聚合**和**裁剪**然后暴露给不同的客户端

### SpringCloud
> Spring Cloud是一套整合微服务开发的工具集，包含有多个子项目，大大简化了分布式开发
- SpringBoot
- Netflix 再分装

### Spring Cloud Eureka
> 基于Netflix Eureka做了二次分装
1. 组件组成：
  - Eureka Server 注册中心 
  - Eureka Client 服务发现
2. 总结：
  - @EnableEurekaServer：开启Eureka服务端服务，用于注册Eureka客户端服务
  - @EnableDiscoveryClient：开启Eureka客户端服务
  - 心跳检测、健康检查、负载均衡等功能
  - Eureka的高可用、生产上建议至少两台以上
  - 分布式系统中，服务注册中心是最重要的基础部分

### 服务发现
1. 客户端发现(客户端直接通过注册中心找到服务端)：Eureka
2. 服务端发现(客户端请求代理在注册中心找到服务端)：
  - Nginx
  - Zookeeper
  - Kubernetes


### SpringCloud服务间Restful的两种通信方式
1. RestTemplate
2. Feign

### Ribbon(客户端负载均衡器)

#### 使用了Ribbon的服务
  1. RestTemplate
  2. Feign
  3. Zuul

#### Ribbon的核心
  1. 服务发现 - 依赖服务的名字将注册在服务中心的实例全部找出
  2. 服务选择规则 - 依据规则策略如何从多个服务中选取有效服务
  3. 服务监听 - 检测失效的服务，实现高效剔除

#### Ribbon的主要组件
1. ServierList - 获取所有有效服务
2. ServerListFilter - 根据规则过滤一部分服务
3. IRule - 选择一个实例作为最终目标结果

