### apache commons 中的工具类使用
1. String 内容占位替换
    ```
    org.apache.commons.lang3.text.StrSubstitutor
    Map valuesMap = HashMap();  
    valuesMap.put("animal", "quick brown fox");  
    valuesMap.put("target", "lazy dog");  
    String templateString = "The ${animal} jumped over the ${target}.";  
    StrSubstitutor sub = new StrSubstitutor(valuesMap);  
String resolvedString = sub.replace(templateString)  
    ```
2. lang中重新hashCode和equal方法
    ```
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
        //    return new HashCodeBuilder(17, 37)
        //          .append(super.getId())
        //          .append(pid)
        //          .append(cls)
        //          .append(layout)
        //          .append(menuCode)
        //          .append(name)
        //          .append(sequence)
        //          .append(url)
        //          .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
        //    if (obj == this) {
        //       return true;
        //    }
        //    if(!(obj instanceof SysMenu)){
        //       return false;
        //    }
        //    SysMenu sysMenu = (SysMenu) obj;
        //    return new EqualsBuilder().append(super.getId(),sysMenu.getId())
        //          .append(pid,sysMenu.getPid())
        //          .append(cls,sysMenu.getCls())
        //          .append(layout,sysMenu.getLayout())
        //          .append(menuCode,sysMenu.getMenuCode())
        //          .append(name,sysMenu.getName())
        //          .append(sequence,sysMenu.getSequence())
        //          .append(url,sysMenu.getUrl()).isEquals();
    }
    ```