package eu.maciejfijalkowski.ksiaze.Utils;

public class IndexCount {
    private String index;

    public IndexCount() {
    }

    public IndexCount(String index){
        this.index=index;
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
