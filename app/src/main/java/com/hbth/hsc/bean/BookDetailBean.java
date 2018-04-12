package com.hbth.hsc.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Administrator on 2018/2/10.
 */

public class BookDetailBean implements Parcelable {

    /**
     * epub : {"id":36980,"bookName":"现代出版.2014.4期","author":"中国传媒大学编辑出版研究中心","publisher":"中国传媒大学出版社","summary":"出版工作-管理","price":"15.0","pubdate":"2011-01-01","pages":0,"classID":"G239.22","category":"《现代出版》杂志为中文核心期刊、中国社会科学引文索引来源（CSSCI）期刊，由现代出版杂志编辑部编辑出版，主办方为中国大学出版社协会、中国传媒大学出版社、中国传媒大学编辑出版研究中心，现为双月刊。","bookUrl":"EPUB2\\2095-0330(3)","picUrl":"http://222.223.215.75:8083/book/EPUB2/cover/2095-0330(3).jpg","isbn":"2095-0330(3)"}
     * url : [{"name":"封面","url":"http://222.223.215.75:8083/book/EPUB2/2095-0330(3)/OEBPS/Text/coverpage.html","size":null,"videoLong":null},{"name":"版权页","url":"http://222.223.215.75:8083/book/EPUB2/2095-0330(3)/OEBPS/Text/front001.html","size":null,"videoLong":null},{"name":"出版名家\u2014\u2014夏瑞芳","url":"http://222.223.215.75:8083/book/EPUB2/2095-0330(3)/OEBPS/Text/front002.html","size":null,"videoLong":null},{"name":"编委会","url":"http://222.223.215.75:8083/book/EPUB2/2095-0330(3)/OEBPS/Text/front003.html","size":null,"videoLong":null},{"name":"文前","url":"http://222.223.215.75:8083/book/EPUB2/2095-0330(3)/OEBPS/Text/front004.html","size":null,"videoLong":null},{"name":"目录","url":"http://222.223.215.75:8083/book/EPUB2/2095-0330(3)/OEBPS/Text/front005.html","size":null,"videoLong":null},{"name":"特稿","url":"http://222.223.215.75:8083/book/EPUB2/2095-0330(3)/OEBPS/Text/chapter001.html#a006","size":null,"videoLong":null},{"name":"理论前沿","url":"http://222.223.215.75:8083/book/EPUB2/2095-0330(3)/OEBPS/Text/chapter002.html#a007","size":null,"videoLong":null},{"name":"版权研究","url":"http://222.223.215.75:8083/book/EPUB2/2095-0330(3)/OEBPS/Text/chapter006.html#a008","size":null,"videoLong":null},{"name":"经营与管理","url":"http://222.223.215.75:8083/book/EPUB2/2095-0330(3)/OEBPS/Text/chapter007.html#a009","size":null,"videoLong":null},{"name":"数字时代","url":"http://222.223.215.75:8083/book/EPUB2/2095-0330(3)/OEBPS/Text/chapter011.html#a010","size":null,"videoLong":null},{"name":"编辑与策划","url":"http://222.223.215.75:8083/book/EPUB2/2095-0330(3)/OEBPS/Text/chapter012.html#a011","size":null,"videoLong":null},{"name":"实践案例","url":"http://222.223.215.75:8083/book/EPUB2/2095-0330(3)/OEBPS/Text/chapter016.html#a012","size":null,"videoLong":null},{"name":"出版教育研究","url":"http://222.223.215.75:8083/book/EPUB2/2095-0330(3)/OEBPS/Text/chapter017.html#a013","size":null,"videoLong":null},{"name":"出版史研究","url":"http://222.223.215.75:8083/book/EPUB2/2095-0330(3)/OEBPS/Text/chapter018.html#a014","size":null,"videoLong":null},{"name":"出版与文化","url":"http://222.223.215.75:8083/book/EPUB2/2095-0330(3)/OEBPS/Text/chapter020.html#a015","size":null,"videoLong":null},{"name":"书人茶座","url":"http://222.223.215.75:8083/book/EPUB2/2095-0330(3)/OEBPS/Text/chapter022.html#a016","size":null,"videoLong":null},{"name":"环球出版","url":"http://222.223.215.75:8083/book/EPUB2/2095-0330(3)/OEBPS/Text/chapter023.html#a017","size":null,"videoLong":null}]
     */

    private EpubBean epub;
    private List<UrlBean> url;

    public BookDetailBean() {
    }

    protected BookDetailBean(Parcel in) {
        epub = in.readParcelable(EpubBean.class.getClassLoader());
        url = in.createTypedArrayList(UrlBean.CREATOR);
    }

    public static final Creator<BookDetailBean> CREATOR = new Creator<BookDetailBean>() {
        @Override
        public BookDetailBean createFromParcel(Parcel in) {
            return new BookDetailBean(in);
        }

        @Override
        public BookDetailBean[] newArray(int size) {
            return new BookDetailBean[size];
        }
    };

    public EpubBean getEpub() {
        return epub;
    }

    public void setEpub(EpubBean epub) {
        this.epub = epub;
    }

    public List<UrlBean> getUrl() {
        return url;
    }

    public void setUrl(List<UrlBean> url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(epub, i);
        parcel.writeTypedList(url);
    }

    public static class EpubBean implements Parcelable {
        /**
         * id : 36980
         * bookName : 现代出版.2014.4期
         * author : 中国传媒大学编辑出版研究中心
         * publisher : 中国传媒大学出版社
         * summary : 出版工作-管理
         * price : 15.0
         * pubdate : 2011-01-01
         * pages : 0
         * classID : G239.22
         * category : 《现代出版》杂志为中文核心期刊、中国社会科学引文索引来源（CSSCI）期刊，由现代出版杂志编辑部编辑出版，主办方为中国大学出版社协会、中国传媒大学出版社、中国传媒大学编辑出版研究中心，现为双月刊。
         * bookUrl : EPUB2\2095-0330(3)
         * picUrl : http://222.223.215.75:8083/book/EPUB2/cover/2095-0330(3).jpg
         * isbn : 2095-0330(3)
         */

        private int id;
        private String bookName;
        private String author;
        private String publisher;
        private String summary;
        private String price;
        private String pubdate;
        private int pages;
        private String classID;
        private String category;
        private String bookUrl;
        private String picUrl;
        private String isbn;

        public EpubBean() {
        }

        protected EpubBean(Parcel in) {
            id = in.readInt();
            bookName = in.readString();
            author = in.readString();
            publisher = in.readString();
            summary = in.readString();
            price = in.readString();
            pubdate = in.readString();
            pages = in.readInt();
            classID = in.readString();
            category = in.readString();
            bookUrl = in.readString();
            picUrl = in.readString();
            isbn = in.readString();
        }

        public static final Creator<EpubBean> CREATOR = new Creator<EpubBean>() {
            @Override
            public EpubBean createFromParcel(Parcel in) {
                return new EpubBean(in);
            }

            @Override
            public EpubBean[] newArray(int size) {
                return new EpubBean[size];
            }
        };

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPubdate() {
            return pubdate;
        }

        public void setPubdate(String pubdate) {
            this.pubdate = pubdate;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public String getClassID() {
            return classID;
        }

        public void setClassID(String classID) {
            this.classID = classID;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getBookUrl() {
            return bookUrl;
        }

        public void setBookUrl(String bookUrl) {
            this.bookUrl = bookUrl;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        @Override
        public String toString() {
            return "EpubBean{" +
                    "id=" + id +
                    ", bookName='" + bookName + '\'' +
                    ", author='" + author + '\'' +
                    ", publisher='" + publisher + '\'' +
                    ", summary='" + summary + '\'' +
                    ", price='" + price + '\'' +
                    ", pubdate='" + pubdate + '\'' +
                    ", pages=" + pages +
                    ", classID='" + classID + '\'' +
                    ", category='" + category + '\'' +
                    ", bookUrl='" + bookUrl + '\'' +
                    ", picUrl='" + picUrl + '\'' +
                    ", isbn='" + isbn + '\'' +
                    '}';
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(id);
            parcel.writeString(bookName);
            parcel.writeString(author);
            parcel.writeString(publisher);
            parcel.writeString(summary);
            parcel.writeString(price);
            parcel.writeString(pubdate);
            parcel.writeInt(pages);
            parcel.writeString(classID);
            parcel.writeString(category);
            parcel.writeString(bookUrl);
            parcel.writeString(picUrl);
            parcel.writeString(isbn);
        }
    }

    public static class UrlBean implements Parcelable {
        /**
         * name : 封面
         * url : http://222.223.215.75:8083/book/EPUB2/2095-0330(3)/OEBPS/Text/coverpage.html
         * size : null
         * videoLong : null
         */

        private String name;
        private String url;
        private Object size;
        private Object videoLong;

        public UrlBean() {
        }

        protected UrlBean(Parcel in) {
            name = in.readString();
            url = in.readString();
        }

        public static final Creator<UrlBean> CREATOR = new Creator<UrlBean>() {
            @Override
            public UrlBean createFromParcel(Parcel in) {
                return new UrlBean(in);
            }

            @Override
            public UrlBean[] newArray(int size) {
                return new UrlBean[size];
            }
        };

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Object getSize() {
            return size;
        }

        public void setSize(Object size) {
            this.size = size;
        }

        public Object getVideoLong() {
            return videoLong;
        }

        public void setVideoLong(Object videoLong) {
            this.videoLong = videoLong;
        }

        @Override
        public String toString() {
            return "UrlBean{" +
                    "name='" + name + '\'' +
                    ", url='" + url + '\'' +
                    ", size=" + size +
                    ", videoLong=" + videoLong +
                    '}';
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(name);
            parcel.writeString(url);
        }
    }

    @Override
    public String toString() {
        return "BookDetailBean{" +
                "epub=" + epub +
                ", url=" + url +
                '}';
    }
}
