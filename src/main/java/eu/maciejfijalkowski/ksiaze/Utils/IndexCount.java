package eu.maciejfijalkowski.ksiaze.Utils;

public class IndexCount {
    private String index;

    private static IndexCount ourInstance = new IndexCount();

    public static IndexCount getInstance() {
        return ourInstance;
    }

    private IndexCount() {
    }


    public String count (){
        return index.substring(21).replaceAll("\\s+","");
    }

    public String count (String index){
        index=index.replaceAll("\\s+","");
        if(index.length()>=24)
            return index.substring(17);
        return "000000000";
    }

    public void setIndex(String index) {
        if(index.length()>=10 || !index.matches("\\d+"))
            this.index = "000000000";
        else
            this.index = index;
    }

    public String getIndex() {
        return index;
    }
}
