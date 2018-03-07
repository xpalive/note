### ElasticSearch6.0

1. ik配置文件
    > ik配置文件地址：es/plugins/ik/config目录  
      IKAnalyzer.cfg.xml：用来配置自定义词库  
      main.dic：ik原生内置的中文词库，总共有27万多条，只要是这些单词，都会被分在一起  
      quantifier.dic：放了一些单位相关的词  
      suffix.dic：放了一些后缀  
      surname.dic：中国的姓氏  
      stopword.dic：英文停用词  
      ik原生最重要的两个配置文件  
      main.dic：包含了原生的中文词语，会按照这个里面的词语去分词  
      stopword.dic：包含了英文的停用词  
      停用词，stopword  
      a the and at but  
      一般，像停用词，会在分词的时候，直接被干掉，不会建立在倒排索引中  

2. 自定义词库
    > (1)自己建立词库：每年都会涌现一些特殊的流行词，网红，蓝瘦香菇，喊麦，鬼畜，一般不会在ik的原生词典里
      自己补充自己的最新的词语，到ik的词库里面去  
      IKAnalyzer.cfg.xml：ext_dict，custom/mydict.dic  
      补充自己的词语，然后需要重启es，才能生效  
      (2)自己建立停用词库：比如了，的，啥，么，我们可能并不想去建立索引，让人家搜索
      custom/ext_stopword.dic，已经有了常用的中文停用词，可以补充自己的停用词，然后重启es
3. 分词测试
    > 分词测试失败,请在某个索引下调用analyze接口测试,而不是直接调用analyze接口   
    如:http://localhost:9200/your_index/_analyze?text=中华人民共和国MN&tokenizer=my_ik