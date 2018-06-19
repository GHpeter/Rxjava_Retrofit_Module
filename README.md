
1 模块化实现（module+router）

本套模块化方案实现来源于对模块化的概念理解，且根据公司业务考虑，代码越来越臃肿，越来越难维护，为了提升开发效率，减低代码的维护成本，所以采取了模块化开发方案。          
既然是模块化开发，必然要考虑到各个module的开发，调试，迭代拓展及维护，module之间不仅需要做到业务代码隔离，还需要方便的跳转(路由引导模块)，方便的传递数据（包括大容量的数据），能够独立编译调。最后，各个module，完成之后，一起打包到主APP即可。         

2 本套模块化方案实现特点    

支持module单独作为Application编译调试     
支持动态注入路由    
支持注解方式注入路由      
支持module之间传大容量的数据     
路由引导模块：自动生成module之间的跳转调用方法      
moduleEventBus：实现module之间通信(此基础项目版本中暂未使用)   

3 项目代码主体架构设计      

app： 一个空壳，本身不参加业务逻辑，最终打包成完整的release APK 
UserCenter：实现用户中心模块业务逻辑代码
Provider：主要存放业务相关的entity或sp数据等
baselib：主要是最基础的可共用的类，比如：baseActivity,baseFragment等




4 代码实现方案

4.1 module的apllication实现    
module能单独作为Application编译    
module在debug和release状态下，业务层代码对application方法调用完全一样   
module在release状态下，能够调用主App的application      
4.1.1 首先gradle配置如下配置      
```        
  def isDebug = rootProject.ext.isUserModule        
if (isDebug) {        
    apply plugin: 'com.android.application'       
} else {        
    apply plugin: 'com.android.library'     
}   
```




