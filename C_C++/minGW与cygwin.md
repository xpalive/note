## MingW和cygwin都可以用来跨平台开发。  
### MinGW
> MinGW是Minimalistic GNU for Windows的缩写，也就是Win版的GCC。 
相对的MingW也有一个叫MSys（Minimal SYStem）的子项目，
主要是提供了一个模拟Linux的Shell和一些基本的Linux工具。
因为编译一个大型程序，光靠一个GCC是不够的，还需要有Autoconf等工具来配置项目，
所以一般在Windows下编译ffmpeg等Linux下的大型项目都是通过Msys来完成的，
当然Msys只是一个辅助环境，根本的工作还是MingW来做的。

### Cygwin
> Cygwin则是全面模拟了Linux的接口，提供给运行在它上面的的程序使用，
并提供了大量现成的软件，更像是一个平台。

### 用MingW和cygwin编译出来的程序的区别。
> 首先,MingW和cygwin都不能让Linux下的程序直接运行在Windows上，必需通过源代码重新编译。
现代操作系统包括Windows和Linux的基本设计概念像进程线程地址空间虚拟内存这些都是大同小异
的，之所以二者上的程序不能兼容，主要是它们对这些功能具体实现上的差异，首先是可执行文件
的格式，Window使用PE的格式，并且要求以.EXE为后缀名。Linux则使用Elf。

> 其次,操作系统的API也不一样，如Windows用CreateProcess()创建进程，而Linux使用fork()。
所以要移植程序必然要在这些地方进行改变，MingW有专门的W32api头文件，来把代码中Linux方式
的系统调用替换为对应的Windows方式。而Cygwin则通过cygwin1.dll这个文件来实现这种API的转换
，并模拟一个Linux系统调用接口给程序，程序依然以Linux的方式调用系统API，只不过这个API在
cygwin1.dll上，cygwin1.dll再调用Windows对应的实现，来把结果返回给程序。可以用查看他们编
译好的程序的导入表来验证这点。二者生成的程序都是能在Windows上运行的EXE文件，显然都是PE
格式，用一个PE格式查看工具检查一下就能发现，Cygwin生成的程序依然有fork()这样的Linux系统
调用，但目标库是cygwin1。而MingW生成的程序，则全部使用从KERNEL32导出的标准Windows系统API。
这样看来用Mingw编译的程序性能会高一点，而且也不用带着那个接近两兆的cygwin1.dll文件。但
Cygwin对Linux的模拟比较完整，甚至有一个Cygwin X的项目，可以直接用Cygwin跑X。另外Cygwin
可以设置-mno-cygwin的flag，来使用Mingw编译。而与Cygwin更有可比性的MSys上的工具也是通过
Cygwin这种模拟的方式来提供的。总之这两个项目有千丝万缕的关系，一个不恰当的比方，如果
Mingw是MFC，Cygwin就是.NET了。
        
### 备注
*   修改编译器,让window下的编译器把诸如fork的调用翻译成等价的形式--这就是mingw的做法. 
*   修改库,让window提供一个类似unix提供的库,他们对程序的接口如同unix一样,而这些库,当然是由win32的API实现的--这就是cygwin的做法. 