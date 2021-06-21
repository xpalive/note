1. PowerShell通过wsl.exe 进入 linux 命令行
2. PowerShell通过wsl [command] 执行命令行


1. 配置
  > /etc/wsl.conf //如果没有就创建
  ```shell script
     # Enable extra metadata options by default
     [automount]
     enabled = true
     root = /windir/
     options = "metadata,umask=22,fmask=11"
     mountFsTab = false
     
     # Enable DNS – even though these are turned on by default, we'll specify here just to be explicit.
     [network]
     generateHosts = true
     generateResolvConf = true
  ```


1.配置
  > C:\Users\<yourUserName>\.wslconfig //如果没有就创建
  ```shell script
    [wsl2]
    kernel=C:\\temp\\myCustomKernel # An absolute Windows path to a custom Linux kernel.
    memory=4GB # Limits VM memory in WSL 2 to 4 GB
    processors=2 # Makes the WSL 2 VM use two virtual processors
  ```

1.wsl 默认访问位置
```shell script
\\wsl$
```

1. [WSL commands and launch configurations] https://docs.microsoft.com/en-us/windows/wsl/wsl-config
1. [Get started mounting a Linux disk in WSL 2] https://docs.microsoft.com/en-us/windows/wsl/wsl2-mount-disk
1. [Docker Desktop WSL 2 backend] https://docs.docker.com/docker-for-windows/wsl/
