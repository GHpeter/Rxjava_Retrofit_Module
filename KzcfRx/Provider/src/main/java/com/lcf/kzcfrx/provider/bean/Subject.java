package com.lcf.kzcfrx.provider.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/5/29
 * Description:
 **/
public class Subject implements Serializable {
    /**
     * rating : {"max":10,"average":9.5,"stars":"50","min":0}
     * genres : ["剧情","爱情","同性"]
     * title : 霸王别姬
     * casts : [{"alt":"https://movie.douban.com/celebrity/1003494/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp"},"name":"张国荣","id":"1003494"},{"alt":"https://movie.douban.com/celebrity/1050265/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p46345.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p46345.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p46345.webp"},"name":"张丰毅","id":"1050265"},{"alt":"https://movie.douban.com/celebrity/1035641/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1399268395.47.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1399268395.47.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1399268395.47.webp"},"name":"巩俐","id":"1035641"}]
     * collect_count : 825589
     * original_title : 霸王别姬
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1023040/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1379615419.48.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1379615419.48.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1379615419.48.webp"},"name":"陈凯歌","id":"1023040"}]
     * year : 1993
     * images : {"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910813120.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910813120.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910813120.webp"}
     * alt : https://movie.douban.com/subject/1291546/
     * id : 1291546
     */

    private RatingBean rating;
    private String title;
    private int collect_count;
    private String original_title;
    private String subtype;
    private String year;
    private ImagesBean images;
    private String alt;
    private String id;
    private List<String> genres;
    private List<CastsBean> casts;
    private List<DirectorsBean> directors;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public static class RatingBean {
        /**
         * max : 10
         * average : 9.5
         * stars : 50
         * min : 0
         */

        private int max;
        private double average;
        private String stars;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class ImagesBean {
        /**
         * small : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910813120.webp
         * large : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910813120.webp
         * medium : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1910813120.webp
         */

        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class CastsBean {
        /**
         * alt : https://movie.douban.com/celebrity/1003494/
         * avatars : {"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp"}
         * name : 张国荣
         * id : 1003494
         */

        private String alt;
        private AvatarsBean avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBean {
            /**
             * small : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp
             * large : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp
             * medium : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p67.webp
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class DirectorsBean {
        /**
         * alt : https://movie.douban.com/celebrity/1023040/
         * avatars : {"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1379615419.48.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1379615419.48.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1379615419.48.webp"}
         * name : 陈凯歌
         * id : 1023040
         */

        private String alt;
        private AvatarsBeanX avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBeanX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanX avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBeanX {
            /**
             * small : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1379615419.48.webp
             * large : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1379615419.48.webp
             * medium : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1379615419.48.webp
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    @Override
    public String toString() {
        return "Subject{" +
                "rating=" + rating +
                ", title='" + title + '\'' +
                ", collect_count=" + collect_count +
                ", original_title='" + original_title + '\'' +
                ", subtype='" + subtype + '\'' +
                ", year='" + year + '\'' +
                ", images=" + images +
                ", alt='" + alt + '\'' +
                ", id='" + id + '\'' +
                ", genres=" + genres +
                ", casts=" + casts +
                ", directors=" + directors +
                '}';
    }
}