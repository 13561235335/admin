package cn.exrick.xboot.your.dto;

import java.util.Collections;

/**
 * @authorhuolongguo
 * @date2021/2/23 11:02 下午
 */
public enum AnalysisTypeENUM {

    ONE("one", 1),
    TWO("two", 2),
    THREE("three", 3),
    FOUR("four", 4),
    FIVE("five", 5),
    SIX("six", 6),
    SEVEN("seven", 7),
    EIGHT("eight", 8),
    NINE("nine", 9),
    TEN("ten", 10),
    ELEVEN("eleven", 11);

    private AnalysisTypeENUM(String english , int value ){
        this.english = english ;
        this.value = value ;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    private String english ;
    private int value ;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public static AnalysisTypeENUM getAnalysisTypeENUM(Integer param){
        for (AnalysisTypeENUM analysisTypeENUM : AnalysisTypeENUM.values()) {
            if (analysisTypeENUM.value == param) {
                return analysisTypeENUM;
            }
        }
        return null;
    }
    public static AnalysisTypeENUM getMaxENUM(){
        AnalysisTypeENUM[] values = AnalysisTypeENUM.values();
        AnalysisTypeENUM sum = values[0];//假设第一个元素是最大值
        //for循环遍历数组中元素，每次循环跟数组索引为0的元素比较大小
        for (int i = 0; i < values.length; i++){
            if (sum.value < values[i].value){//数组中的元素跟sum比较，比sum大就把它赋值给sum作为新的比较值
                sum = values[i];
            }
        }
        return sum;
    }

    public static AnalysisTypeENUM getMinENUM(){
        AnalysisTypeENUM[] values = AnalysisTypeENUM.values();
        AnalysisTypeENUM sum = values[0];//假设第一个元素是最大值
        //for循环遍历数组中元素，每次循环跟数组索引为0的元素比较大小
        for (int i = 0; i < values.length; i++){
            if (sum.value > values[i].value){//数组中的元素跟sum比较，比sum小就把它赋值给sum作为新的比较值
                sum = values[i];
            }
        }
        return sum;
    }
}
