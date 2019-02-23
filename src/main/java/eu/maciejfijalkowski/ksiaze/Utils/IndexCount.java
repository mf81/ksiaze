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
        this.index = index.substring(21).replaceAll("\\s+","");
        return this.index;
    }

    public String getIndex() {
        return index;
    }
}
