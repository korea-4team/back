package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.ResponseDto;
import com.team.back.dto.request.eventBoard.PatchEventBoardRequestDto;
import com.team.back.dto.request.eventBoard.PostEventBoardRequestDto;
import com.team.back.dto.response.eventBoard.DeleteEventBoardResponseDto;
import com.team.back.dto.response.eventBoard.EventBoardListResponseDto;
import com.team.back.dto.response.eventBoard.GetEventBoardListResponseDto;
import com.team.back.dto.response.eventBoard.GetEventBoardResponseDto;
import com.team.back.dto.response.eventBoard.PatchEventBoardResponseDto;
import com.team.back.dto.response.eventBoard.PostEventBoardResponseDto;
import com.team.back.entity.EventBoardEntity;
import com.team.back.entity.EventBoardViewEntity;
import com.team.back.entity.resultSet.EventBoardListResultSet;
import com.team.back.repository.AdminRepository;
import com.team.back.repository.EventBoardRepository;
import com.team.back.repository.EventBoardViewRepository;
import com.team.back.service.EventBoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventBaordServiceImplement implements EventBoardService {

    private final AdminRepository adminRepository;
    private final EventBoardRepository eventBoardRepository;
    private final EventBoardViewRepository eventBoardViewRepository;


    // 이벤트 게시물 리스트 최신순으로 불러오기 //
    @Override
    public ResponseEntity<? super GetEventBoardListResponseDto> getEventBoardList(Integer section) {
        
        List<EventBoardListResponseDto> eventBoardList = null;

        try {
            Integer limit = (section - 1) * 30;
            List<EventBoardListResultSet> resultSets = eventBoardRepository.getEventBoardList(limit);

            eventBoardList = EventBoardListResponseDto.copyList(resultSets);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetEventBoardListResponseDto.success(eventBoardList);

    }

    @Override
    public ResponseEntity<? super GetEventBoardResponseDto> getEventBoard(Integer boardNumber) {
        
        EventBoardViewEntity eventBoardViewEntity = null;

        try {
            eventBoardViewEntity = eventBoardViewRepository.findByBoardNumber(boardNumber);

            if (eventBoardViewEntity == null) return GetEventBoardResponseDto.noExistedBoard();
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetEventBoardResponseDto.success(eventBoardViewEntity);
    }

    @Override
    public ResponseEntity<? super PostEventBoardResponseDto> postEventBoard(String writerEmail, PostEventBoardRequestDto dto) {
        
        try {
            boolean hasAdmin = adminRepository.existsByAdminId(writerEmail);
            if (!hasAdmin) return PostEventBoardResponseDto.notAdminId();

            EventBoardEntity eventBoardEntity = new EventBoardEntity(writerEmail, dto);

            eventBoardRepository.save(eventBoardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostEventBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchEventBoardResponseDto> patchEventBoard(Integer boardNumber, String writerEmail, PatchEventBoardRequestDto dto) {
        
        try {
            boolean hasAdmin = adminRepository.existsByAdminId(writerEmail);
            if (!hasAdmin) return PatchEventBoardResponseDto.notAdminId();

            EventBoardEntity eventBoardEntity = eventBoardRepository.findByBoardNumber(boardNumber);
            if(eventBoardEntity == null) return PatchEventBoardResponseDto.noExistedBoard();

            eventBoardEntity.patch(dto);

            eventBoardRepository.save(eventBoardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PatchEventBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super DeleteEventBoardResponseDto> deleteEventBoard(Integer boardNumber, String writerEmail) {
        
        try {
            boolean hasAdmin = adminRepository.existsByAdminId(writerEmail);
            if (!hasAdmin) return PatchEventBoardResponseDto.notAdminId();

            EventBoardEntity eventBoardEntity = eventBoardRepository.findByBoardNumber(boardNumber);
            if(eventBoardEntity == null) return PatchEventBoardResponseDto.noExistedBoard();

            eventBoardRepository.delete(eventBoardEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return DeleteEventBoardResponseDto.success();
    }
    
}
