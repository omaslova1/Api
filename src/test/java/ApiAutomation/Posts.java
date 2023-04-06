package ApiAutomation;

public class Posts {

    public String content;
    public String name;
    public String job;
    public String count;
    public String prevPage;
    public String nextPage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPrevPage() {
        return prevPage;
    }

    public void setPrevPage(String prevPage) {
        this.prevPage = prevPage;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }
    public String getCount() {
        return count;
    }
    public void setCount(String count) {
        this.count = count;
    }
    public Posts(String name, String job, String content, String prevPage, String nextPage, String count) {
        this.name = name;
        this.job = job;
        this.content = content;
        this.prevPage = prevPage;
        this.nextPage = nextPage;
        this.count = count;
    }



        public Posts(String name, String job) {
            this.name = name;
            this.job = job;

        }
}

