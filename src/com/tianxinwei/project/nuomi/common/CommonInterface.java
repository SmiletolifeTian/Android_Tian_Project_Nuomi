package com.tianxinwei.project.nuomi.common;

public class CommonInterface {
	// 分类接口
	public static final String URI_CATEGORY = "http://app.nuomi.com/naserver/home/homepage?logpage=Home&cityid=300210000&appid=android&tn=android&terminal_type=android&device=Genymotion+Google+Nexus+S+-+4.1.1+-+API+16+-+480x800&channel=1006900a&v=5.0.2&os=SDK16&location=0&cuid=477AD5CF1A3CC8B6073AD245387DCAA7000000000000000&uuid=ffffffff-bcbf-43b9-9c1c-96300033c587&timestamp=1410866512822&swidth=480&sheight=728&net=wifi&sign=d19662517af1fc33c387f9aa1b6344d1";

	// 猜你喜欢
	public static final String URI_TUAN_LIKE = "http://app.nuomi.com/naserver/search/likeitem?logpage=Home&cityid=300210000&appid=android&tn=android&terminal_type=android&device=Genymotion+Google+Nexus+S+-+4.1.1+-+API+16+-+480x800&channel=1006900a&v=5.0.2&os=SDK16&location=0&cuid=477AD5CF1A3CC8B6073AD245387DCAA7000000000000000&uuid=ffffffff-bcbf-43b9-9c1c-96300033c587&timestamp=1410866512845&swidth=480&sheight=728&net=wifi&sign=d6dc9a24e2a74a0750443bbc19acfe1a";

	// 全部团购 - 修改page_idx属性，分页查看
	public static final String URI_TUAN_ALL = "http://app.nuomi.com/naserver/search/commonitem?logpage=CateList&locate_city_id=0&page_idx=0&location=0&bizarea_list=0&sort_type=0&goods_per_page=15&fst_cattag_id=0&appid=android&tn=android&terminal_type=android&device=Genymotion+Google+Nexus+S+-+4.1.1+-+API+16+-+480x800&channel=1006900a&v=5.0.2&os=SDK16&cityid=300210000&cuid=477AD5CF1A3CC8B6073AD245387DCAA7000000000000000&uuid=ffffffff-bcbf-43b9-9c1c-96300033c587&timestamp=1411024201362&swidth=480&sheight=728&net=wifi&sign=6d72fd5841a40b4a9a5d6800e25ee602";

	// 商品详情 - 修改deal_id属性，查看不同商品详情
	//deal_id有值：http://app.nuomi.com/naserver/item/ItemDetailPage?city_id=300210000&logpage=DealDetail&tinyPicHeight=0&tinyPicWidth=204&s=03ee7a98f5817edbaeade39b4a90b8b1&deal_id=1189341&appid=android&tn=android&terminal_type=android&device=Genymotion+Google+Nexus+S+-+4.1.1+-+API+16+-+480x800&channel=1006900a&v=5.0.2&os=SDK16&cityid=300210000&location=0&cuid=477AD5CF1A3CC8B6073AD245387DCAA7000000000000000&uuid=ffffffff-bcbf-43b9-9c1c-96300033c587&timestamp=1411094014849&swidth=480&sheight=728&net=wifi&sign=3205a5e28024bb516ad6766adcf0807b
	public static final String URI_PRODUCT_DEAL = "http://app.nuomi.com/naserver/item/ItemDetailPage?city_id=300210000&logpage=DealDetail&tinyPicHeight=0&tinyPicWidth=204&s=03ee7a98f5817edbaeade39b4a90b8b1&deal_id=%s&appid=android&tn=android&terminal_type=android&device=Genymotion+Google+Nexus+S+-+4.1.1+-+API+16+-+480x800&channel=1006900a&v=5.0.2&os=SDK16&cityid=300210000&location=0&cuid=477AD5CF1A3CC8B6073AD245387DCAA7000000000000000&uuid=ffffffff-bcbf-43b9-9c1c-96300033c587&timestamp=1411094014849&swidth=480&sheight=728&net=wifi&sign=3205a5e28024bb516ad6766adcf0807b";

	// 附近团购
	public static final String URI_TUAN_NEARBY = "http://app.nuomi.com/naserver/search/nearitem?distance=0%2C3000&logpage=NearList&locate_city_id=0&page_idx=0&location=0%2C0&sort_type=5&auto_broaden=1&goods_per_page=15&fst_cattag_id=0&appid=android&tn=android&terminal_type=android&device=Genymotion+Google+Nexus+4+-+4.1.1+-+API+16+-+480x800&channel=1006900a&v=5.1.0&os=SDK16&cityid=300210000&cuid=20825776AC6509079C47244242BBEA31%7C000000000000000&uuid=00000000-5814-177a-9c1c-96300033c587&bduss=HFyR0tmZU9XUWZ3Q3pSM1lmak0tNWNQOXpIaWFqOVFzOFR3eHlzdUlSMHE1bGxVQVFBQUFBJCQAAAAAAAAAAAEAAACXU%7EQJ0KGzx9K7xrMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACpZMlQqWTJUO&timestamp=1412598942974&swidth=480&sheight=728&net=wifi&sign=878ccb798ab9535c09c4f2df341690f3";

	// 新版本更新
	public static final String URI_UPDATE_SERVER = "http://app.nuomi.com/naserver/user/appupdate?appv=5.1.0&channelType=android&appid=android&tn=android&terminal_type=android&device=Genymotion+Google+Nexus+4+-+4.1.1+-+API+16+-+480x800&channel=1006900a&v=5.1.0&os=SDK16&cityid=300210000&location=0%2C0&cuid=20825776AC6509079C47244242BBEA31%7C000000000000000&uuid=00000000-5814-177a-9c1c-96300033c587&bduss=HFyR0tmZU9XUWZ3Q3pSM1lmak0tNWNQOXpIaWFqOVFzOFR3eHlzdUlSMHE1bGxVQVFBQUFBJCQAAAAAAAAAAAEAAACXU%7EQJ0KGzx9K7xrMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACpZMlQqWTJUO&timestamp=1412669528728&swidth=480&sheight=728&net=wifi&sign=fc1e414b1e108cc6878a73ac2486cf51"; 

	// 本机更新
	public static final String URI_UPDATE_LOCAL = "http://10.2.155.11:8080/nuomi_apk/update.xml";
	
	// APK更新
	public static final String URI_APK="http://10.2.155.11:8080/nuomi_apk/Android_TianXinwei_Project_NuoMi.apk";
	
}
