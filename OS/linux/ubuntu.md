1. 命令补全
ubuntu : sudo apt-get install bash-complection

1. 
ubuntu 开启ssh
  安装服务 apt-get openssh-server
  >报错 sshd: no hostkeys available -- exiting.ssh start
  ```shell script
  生成key
  ssh-keygen -t dsa -f /etc/ssh/ssh_host_dsa_key
  ssh-keygen -t rsa -f /etc/ssh/ssh_host_rsa_key
  重启服务
  service ssh restart
  ```
  ```shell script
    /etc/sshd_config 文件配置
    PermitRootLogin test 是否允许root用户登录 
    PubkeyAuthentication no
    AuthorizedKeysFile 屏蔽
    PasswordAuthentication yes  
  ```

  >修改/etc/ssh/sshd-config文件，将其中的PermitRootLogin no修改为yes，PubkeyAuthentication yes修改为no，AuthorizedKeysFile .ssh/authorized_keys前面加上#屏蔽掉，PasswordAuthentication no修改为yes就可以了。