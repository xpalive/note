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
```
git查看分支
```text
git branch -a
```
git创建分支
```text
git branch [branch name]
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

