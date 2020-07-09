# GDB的安装和配置
为了调试跟踪和运行Python，我们需要配置好一个环境。

## 选择操作系统
目前MacOS对GDB并不友好，在MacOS下使用GDB需要签名，并且还经常会遇到一些其他问题，比如找不到某些标准库的调试信息。   
所以，建议选择一个Linux操作系统，CentOS或Ubuntu什么的都可以。我目前用的是一个CentOS系统。   
你可以用VirtualBox安装一个Linux的虚拟机就行了。

## 安装GDB
在CentOS下，我用下面的命令一股脑装了所有与开发有关的工具包，其中就包含了GDB。
>yum groupinstall "Development Tools”
    
因为我们还要编译Python，上述命令也安装了编译所需的工具链。    

设置.gdbinit文件。该文件位于当前用户的主目录。内容为：
>add-auto-load-safe-path /home/richard/Python-3.8.3   
>set auto-load safe-path /   

其中的目录名，需要换成你自己的。这个配置文件会告诉GDB到哪里去加载Python扩展。

## 安装并编译Python
首先，下载Python3.8.3的源代码,下载链接是：https://github.com/python/cpython/tree/v3.8.3   

下载后的代码放到用户主目录下，比如~/Python-3.8.3


第二步，运行：
>./configure --with-pydebug

第三步，运行：
>make -s -j2   

其中j2是指用几个内核做编译。你根据虚拟机的内核数来修改这个参数。   

## 用GDB调试Python
第一步，运行Python   
打开一个终端（我通常是用ssh连接到Linux上），进入~/Python-3.8.3目录。   
运行：
> ./python  

这样就进入了Python的REPL。   

第二步，运行GDB，并attach到python进程上。
> gdb -p \`pidof python`  

这个命令会找出python的进程id，并attach上去。你也可以用ps命令手工查找python的进程id。


第三步，在GDB里面调试python的运行    
通常，你要先设置断点，然后再跟踪其执行。  
至于GDB的命令，你可以搜索一下，网上有很多介绍文章。多用几遍就熟悉起来了。  







