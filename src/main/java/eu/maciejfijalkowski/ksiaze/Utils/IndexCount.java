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
        if(index.length()>=24){
            this.index = index.substring(21).replaceAll("\\s+","");
            return this.index;
        }
        return "";
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getIndex() {
        return index;
    }
}
