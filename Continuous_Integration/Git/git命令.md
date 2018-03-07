### git 命令
本地仓库关联远程仓库(远程仓库未初始化)
```text
git init //初始化git本地仓库
touch .gitignore //添加忽略文件
git remote add origin <url> //添加远程仓库地址
git add . //将所有文件添加至index
git commit -m "init" //提交至本地仓库
git push -u origin master //推送至远程仓库
```

本地仓库关联远程仓库(远程仓库已初始化)
```text
git init
touch .gitignore
git remote add origin <url>
git add .
git commit -m "init"
git push -u origin master //推送至远程仓库会失败
git branch --set-upstream-to=origin/master master //设置上游仓库关联,可设置多个
git pull //如果出现refusing to merge unrelated histories则用下面的命令
git pull --allow-unrelated-histories //不同版本仓库pull的合并
git push 
```
克隆远程仓库
```text
git clone <url>
git clone -b [branch name] <url>
```

git自动清理本地文件
```text
git gc --auto
```
git将远程分支更新到最新状态(删除已废弃的远程branch)
```text
git fetch -p
or
git remote prune origin
```
git查看分支
```text
git branch -a
```
git创建本地分支
```text
git branch [branch name]
```
git推送本地分支至远程
```text
git push --set-upstream origin [branch name]
```
git切换分支
```text
git checkout [branch name]
```
git删除本地分支
```text
git branch -d [branch name]
```
git删除远程分支
```text
git branch -r -d origin/[branch name]
git push origin :[branch name]
```
git放弃本地修改强制更新
```text
git fetch --all
git reset --hard origin/master
```
> git fetch 只是下载远程的库的内容，不做任何的合并 git reset 把Head指向刚刚下载的最新的版本

git reset命令
```text
git reset --hard HEAD^  //回退到上一个版本
git reset --hard HEAD^100  //回退到上100个版本
git reset --hard [log id]  //回退到指定log id 的版本
```

系统出现如下错误：warning: LF will be replaced by CRLF
```text
git config --gobal core.autocrlf false  //未实际操作过
```
git配置ssl认证
```text
git config --system http.sslverify false/true
```
git查看当前用户名和邮箱地址
```text
git config user.name
git config user.email
修改
git config --global user.name "username"
git config --global user.email "email"
```
> 会生成.gitconfig 文件   
仅仅是用于提交时的用户信息配置，并非用户名密码

通过git命令可以存储git账号名密码，第一次需要输入，之后不需要在当前系统下会生成.git-credentials 文件用于存储用户名密码
```text
git config --global credential.helper store
```