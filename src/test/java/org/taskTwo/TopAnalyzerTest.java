package org.taskTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TopAnalyzerTest {

    @Test
    public void getTop10Test(){
        Post post1 = new Post("1", 40);
        Post post2 = new Post("2", 33);
        Post post3 = new Post("3", 3000);
        Post post4 = new Post("4", 400);
        Post post5 = new Post("5", 5000);
        Post post6 = new Post("6", 6000);
        Post post7 = new Post("7", 8000);
        Post post8 = new Post("8", 9000);
        Post post9 = new Post("9", 10000);
        Post post10 = new Post("10", 20000);
        Post post11 = new Post("11", 3500);

        List<Post> postListForAnalysis = new ArrayList<>();
        postListForAnalysis.add(post1);
        postListForAnalysis.add(post2);
        postListForAnalysis.add(post3);
        postListForAnalysis.add(post4);
        postListForAnalysis.add(post5);
        postListForAnalysis.add(post6);
        postListForAnalysis.add(post7);
        postListForAnalysis.add(post8);
        postListForAnalysis.add(post9);
        postListForAnalysis.add(post10);
        postListForAnalysis.add(post11);

        List<Post> referenceListForCompare = new ArrayList<>();
        referenceListForCompare.add(post10);
        referenceListForCompare.add(post9);
        referenceListForCompare.add(post8);
        referenceListForCompare.add(post7);
        referenceListForCompare.add(post6);
        referenceListForCompare.add(post5);
        referenceListForCompare.add(post11);
        referenceListForCompare.add(post3);
        referenceListForCompare.add(post4);
        referenceListForCompare.add(post1);

        Assertions.assertEquals(referenceListForCompare,TopAnalyzer.getTop10(postListForAnalysis));
    }

    @Test
    public void testForNumberValuesInReturnList(){
        List<Post> postList = new ArrayList<>();
        for(int i = 0; i<=100; i++){
            postList.add(new Post(Integer.toString(i),(int)(Math.random() * 100)));
        }
        List<Post> resultList = TopAnalyzer.getTop10(postList);
        int expectedSizeList = 10;
        Assertions.assertEquals(expectedSizeList,resultList.size());
    }

}
