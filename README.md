# Flash 说明

---

Flash Framework 是一个轻量级应用开发框架，主要由 IOC，MVC，RPC，Test 等常用开发框架构成。

Flash 参考了 Spring 的设计，但绝对不是抄袭，为较低框架以及开发中的复杂度，Flash 完全是构建在
纯注解之上的。

而代码模块，主要包括 core，beans，context，web 等等构成。

core 模块：是资源模块也是整个框架最核心的模块，主要处理与资源相关的问题。

beans 模块：是 Beans 模块，Flash 是面向 POJO 的编程。而且 Beans 模块就是 POJO 的主要处理部
分。所以也可以看作是 Flash 的设计核心模块。

context 模块：是上下文环境模块，是为底层，提供应用舞台的部分，同时也是连接其他模块以及集成外部的
润滑剂。


web 模块：是与 web 相关的模块，主要是 HTTP 基础封装以及 mvc 框架。

