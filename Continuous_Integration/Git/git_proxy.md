### git 代理配置

1. 临时代理
    ```shell script
     git clone "git repository url" config "http(s).proxy=http://127.0.0.1:8080"
     git clone "git repository url" config "http(s).proxy=socks5://127.0.0.1:8080"
    ```
1. 配置代理：修改 ~/.ssh/config 文件（不存在则新建）：[原文地址][1]
    ```shell script
     # 必须是 github.com
     Host github.com
        HostName github.com
        User xpalive
        # 走 HTTP 代理
        # ProxyCommand socat - PROXY:127.0.0.1:%h:%p,proxyport=10809
        # 走 socks5 代理（如小飞机 or V2xxx）
        # windows 如下
        ProxyCommand connect -S 127.0.0.1:10808 %h %p
        # Linux 如下
        # ProxyCommand nc -v -x 127.0.0.1:1080 %h %p
    ```
1. 



[1]: https://bin.zmide.com/?p=748