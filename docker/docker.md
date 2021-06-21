### docker

##### docker 补全
> 2.1 安装 bash-completion
> 安装完成之后重启系统或者重新登录 shell。如果安装成功。键入 docker p 后，再 Tab 键可显示候选项
> 此时，我们运行例如 docker run 之类的命令，键入镜像的首字母，镜像名称依然无法自动补全。
> /etc/bash_completion.d/docker-compose 通过docker-compose 完善镜像补全
```shell script
sudo yum install -y bash-completion
sudo curl -L https://raw.githubusercontent.com/docker/compose/1.24.1/contrib/completion/bash/docker-compose -o /etc/bash_completion.d/docker-compose
source /etc/bash_completion.d/docker-compose
```