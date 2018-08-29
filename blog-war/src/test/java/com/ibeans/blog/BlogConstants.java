package com.ibeans.blog;


import java.time.LocalDateTime;

/**
 * Created by igotavares on 07/08/2018.
 */
public interface BlogConstants {

    interface PostConstants {
        Long ID_IS_ONE = 1L;
        String TITLE_IS_WELCOME = "Welcome";
        String DESCRIPTION_IS_TO_THE_NEW_WORLD = "to the new world";
        LocalDateTime PUBLICATION_DATE_IS_2018_01_01_00_00_00 =  LocalDateTime.of(2018, 1, 1, 0, 0, 0);

        Long ID_IS_TWO = 2L;
        String TITLE_IS_TITLE = "Title";
        String DESCRIPTION_IS_DESCRIPTPION = "Description";
        LocalDateTime PUBLICATION_DATE_IS_2017_02_03_10_05_03 =  LocalDateTime.of(2017, 2, 3, 10,5,3);
    }

}
