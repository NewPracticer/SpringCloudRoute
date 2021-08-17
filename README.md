# SpringCloudAlibabaStudyRoute

#### 介绍
因Netfilix的相关项目进入维护模式，使用SpringCloudAlibaba相关组件

#### 学习路线
1. https://coding.imooc.com/class/358.html (springcloud alibaba 组件学习)
2. https://coding.imooc.com/class/508.html (Springcloud alibaba组件进阶)
3. https://class.imooc.com/sale/javaarchitect (Springcloud 以及 springcloud alibaba相关组件)

##### Nacos
1. 介绍
    1. 服务发现和健康检测
    2. 动态配置服务
    3. 动态DNS服务
    4. 服务及其元数据管理
2. 数据模型
    1. Namespace:代表不同的运行环境
    2. Group: 代表某一个类配置：比如中间件配置，数据库配置
    3. DateId: 某个项目中具体的配置文件
3. 服务领域模型
    1. Namespace:
    2. Group:
    3. Service:
    4. Cluster
    5. Instance
4. 服务注册流程
    1. 服务提供方
        1. 使用openApi发起服务注册
        2. 建立心跳，检测服务状态
    2. 服务消费者
        1. 查询服务提供方实例列表
        2. 每10秒拉去一次数据
        3. 检测到服务提供者异常基于UDP协议推送更新
##### Seata
1. 分布式事务理论模型
    1. X/OPEN 分布式事务模型
        1. 二阶段提交
        2. 三阶段提交
2. 分布式事务常见的解决方案
    1. TCC 补偿型方案
    2. 基于可靠性消息的最终一致性方案
        1. Rocketmq事务消息
    3. 最大努力通知型
3. Seata介绍
    1. Seata 是阿里开源的一款开源的分布式事务解决方案，致力于提供高性能和简单易用的分布式事务服务。
4. Seata 四种事务模式
    1. AT模式
    2.  TCC模式
    3.  Saga模式
    4.  XA模式
4. 三种角色
    1. TC (Transaction Coordinator) - 事务协调者：维护全局和分支事务的状态，驱动全局事务提交或回滚。
    2. TM (Transaction Manager) - 事务管理器：定义全局事务的范围，开始全局事务、提交或回滚全局事务
    3. RM ( Resource Manager ) - 资源管理器：管理分支事务处理的资源( Resource )，与 TC 交谈以注册分支事务和报告分支事务的状态，并驱动分支事务提交或回滚。
    4. TC 为单独部署的 Server 服务端，TM 和 RM 为嵌入到应用中的 Client 客户端。
5. 整体流程
    1. TM 请求 TC 开启一个全局事务。TC 会生成一个 XID 作为该全局事务的编号。
    2. RM 请求 TC 将本地事务注册为全局事务的分支事务，通过全局事务的 XID 进行关联。
    3. TM 请求 TC 告诉 XID 对应的全局事务是进行提交还是回滚。
    4. TC 驱动 RM 们将 XID 对应的自己的本地事务进行提交还是回滚。