```html
https://linuxize.com/post/how-to-install-google-chrome-web-browser-on-centos-8/
```

```
https://dl.google.com/linux/direct/google-chrome-stable_current_x86_64.rpm
sudo dnf localinstall google-chrome-stable_current_x86_64.rpm
```



Updating Chrome Browser

During the package installation, the official Google repository will be added to your system. Use the following cat command to verify that the file exists:

cat /etc/yum.repos.d/google-chrome.repo

[google-chrome]
name=google-chrome
baseurl=http://dl.google.com/linux/chrome/rpm/stable/x86_64
enabled=1
gpgcheck=1
gpgkey=https://dl.google.com/linux/linux_signing_key.pub

When a new version is released, you can perform an update with dnf or through your desktop standard Software Update tool.
