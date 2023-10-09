package com.team.back.dto.response.banner;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.resultSet.MainBannerListResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MainBannerListResponseDto {
    
    private int bannerNumber;
    private String imageUrl;
    private int sequence;
    private String writeDatetime;
    private String writerEmail;
    private int eventBoardNumber;

    public MainBannerListResponseDto (MainBannerListResultSet resultSet) {
        this.bannerNumber = resultSet.getBannerNumber();
        this.imageUrl = resultSet.getImageUrl();
        this.sequence = resultSet.getSequence();
        this.writeDatetime = resultSet.getWriteDatetime();
        this.writerEmail = resultSet.getWriterEmail();
        this.eventBoardNumber = resultSet.getEventBoardNumber();
    }

    public static List<MainBannerListResponseDto> copyList(List<MainBannerListResultSet> resultSets) {

        List<MainBannerListResponseDto> mainBannerList = new ArrayList<>();

        for (MainBannerListResultSet resultSet : resultSets) {
            MainBannerListResponseDto mainBanner = new MainBannerListResponseDto(resultSet);
            mainBannerList.add(mainBanner);
        }

        return mainBannerList;
    }

}
