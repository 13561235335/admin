package cn.exrick.xboot.your.dto;

import java.util.Collections;

/**
 * @authorhuolongguo
 * @date2021/2/23 11:02 下午
 */
public enum AnalysisTypeENUM {

    ONE("one", "1"),
    TWO("two", "2"),
    THREE("three", "3"),
    FOUR("four", "4"),
    FIVE("five", "5"),
    SIX("six", "6"),
    SEVEN("seven", "7"),
    EIGHT("eight", "8"),
    NINE("nine", "9"),
    TEN("ten", "10"),
    ELEVEN("eleven", "11");

    private String english ;
    private String value ;

    private AnalysisTypeENUM(String english , String value ){
        this.english = english ;
        this.value = value ;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }



    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public static AnalysisTypeENUM getAnalysisTypeENUM(String param){
        for (AnalysisTypeENUM analysisTypeENUM : AnalysisTypeENUM.values()) {
            if (analysisTypeENUM.value == param) {
                return analysisTypeENUM;
            }
        }
        return null;
    }

}
