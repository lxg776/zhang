package com.zheng.cpw;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zheng.cpw.dao.model.CpwNews;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;
import java.util.ArrayList;
import java.util.List;


public class GithubRepoPageProcessor implements PageProcessor {


    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);


//    @Autowired
//    CpwNewsService cpwNewsService;


    @Override
    public void process(Page page) {

       // System.out.println(page.getHtml().css(".jc-article p"));

        Json json = page.getJson();
        JSONObject jsonObject = JSONObject.parseObject(json.get());

        List<CpwNews> newsList =new ArrayList<>();

        if(jsonObject!=null){
            JSONObject data =  jsonObject.getJSONObject("data");
            if(data.getJSONArray("newses")!=null){
                JSONArray newses = data.getJSONArray("newses");
                if(null!=newses&&newses.size()>0){
                    for(int i =0;i<newses.size();i++){
                        CpwNews  item =  jsonToNews(newses.getJSONObject(i));
                        newsList.add(item);
                    }
                }
            }
        }

        for(CpwNews item :newsList){
            System.out.println(item.getTitle());
        }


    }

    private CpwNews jsonToNews(JSONObject jsonObject){
        CpwNews cpwNews = new CpwNews();
        cpwNews.setId(jsonObject.getInteger("id"));
        cpwNews.setAuthor(jsonObject.getString("author"));
        cpwNews.setTitle(jsonObject.getString("title"));
        cpwNews.setBeginTime(jsonObject.getString("beg"));
        cpwNews.setEndTime(jsonObject.getString("end"));
        cpwNews.setLink(jsonObject.getString("link"));
        cpwNews.setSource(jsonObject.getString("source"));

        //cpwNews.setContent(jsonObject.getString("end"));

        return  cpwNews;
    }

    private CpwNews htmlToNews(JSONObject jsonObject){
        CpwNews cpwNews = new CpwNews();
        cpwNews.setId(jsonObject.getInteger("id"));
        cpwNews.setAuthor(jsonObject.getString("author"));
        cpwNews.setTitle(jsonObject.getString("title"));
        cpwNews.setBeginTime(jsonObject.getString("beg"));
        cpwNews.setEndTime(jsonObject.getString("end"));
        cpwNews.setLink(jsonObject.getString("link"));
        cpwNews.setSource(jsonObject.getString("source"));

        //cpwNews.setContent(jsonObject.getString("end"));

        return  cpwNews;
    }




    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new GithubRepoPageProcessor()).addUrl("http://news.cp.lovedou.com/news/todayHot?page=1&pageSize=20").thread(5).run();
    }
}