##主体目录
bin 辅助运行的一些脚本和批处理文件
db 数据库的建立SQL和相关数据
doc 文档文件
lib maven仓库不存在的包，手工安装
src/main 供发布的根目录
src/test 单元测试使用根目录
tool 杂项的各列工具和配置等

##代码部分
java java代码根目录
    common 通用的代码类
    controller 控制器
    form 对于前端输入的form校验【只在和model对象有差异是才启用，默认情况下，在model上直接添加】
    repository DAO层，注意这个是和SQL访问相关的部分
        普通的CRUD之类的数据库操作，直接在controller使用即可
        每个实体定义一下接口，并定义符合业务的函数即可【按照约定的自动查询方法、使用SQL的查询方法 2种方式】
    model 数据库实体类，优选code-first的形式，由代码建立表
    service 服务部分
        处理实体之间的关联关系时，如果需要同时看到父子对象，此时需要在service中编写
resources 各类配置文件
    dbg_* 开头的表示只在开发环境下使用

##运行说明
    Proifle: 不同的运行环境，默认使用完整的和部署一致的形式
        test: 使用的是H2内存数据库
            预置数据的脚本在db/**下，由spring启动时自动处理，作用于内存数据库H2
        production： 这个和真实的部署环境一致，mysql
        默认使用的是mysql部署【和发布一致】
    运行
        开发运行： mvn jetty:run -Dspring.profiles.active=test
        单元测试运行： mvn test -Dspring.profiles.active=test target\surefire-reports下有txt xml格式的
            mvn ## -P test 加载 profile不起作用
        mvn surefire-report:report 生成HTML单元测试报告 target\site\surefire-report.html
        mvn site 查看项目的各种依赖信息