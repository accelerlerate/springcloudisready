package com.prey.pojo;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.*;

/**
 * @author prey
 * @description:
 **/
@Data
@Document(indexName = "product",type = "doc")
public class Product {

    @Field(store = true,type = FieldType.Keyword)
    private Long id;

    @MultiField(
            mainField = @Field(type = FieldType.Keyword),
            otherFields = {
                    @InnerField(type = FieldType.Text, suffix = "ik", analyzer = "ik_max_word", searchAnalyzer = "ik_max_word"),
                    @InnerField(type = FieldType.Text, suffix = "ik_pinyin", analyzer = "ik_pinyin_analyzer", searchAnalyzer = "ik_pinyin_analyzer"),
                    @InnerField(type = FieldType.Text, suffix = "pinyin", analyzer = "pinyin_analyzer", searchAnalyzer = "pinyin_analyzer")
            }
    )
    private String productName;

    @MultiField(
            mainField = @Field(type = FieldType.Keyword),
            otherFields = {
                    @InnerField(type = FieldType.Text, suffix = "ik", analyzer = "ik_max_word", searchAnalyzer = "ik_max_word"),
                    @InnerField(type = FieldType.Text, suffix = "ik_pinyin", analyzer = "ik_pinyin_analyzer", searchAnalyzer = "ik_pinyin_analyzer"),
                    @InnerField(type = FieldType.Text, suffix = "pinyin", analyzer = "pinyin_analyzer", searchAnalyzer = "pinyin_analyzer")
            }
    )
    private String category;

    @Field(store = true, type = FieldType.Double)
    private Double price;


}
