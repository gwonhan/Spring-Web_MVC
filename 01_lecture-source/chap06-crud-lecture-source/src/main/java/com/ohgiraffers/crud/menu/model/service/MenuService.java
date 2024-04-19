package com.ohgiraffers.crud.menu.model.service;

import com.ohgiraffers.crud.menu.model.dao.MenuMapper;
import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    private final MenuMapper menuMapper;

    @Autowired
    public MenuService(MenuMapper menuMapper){
        this.menuMapper =menuMapper;
    }
    public List<MenuDTO> findAllMenus() {

        return menuMapper.findAllMenu();
    }

    public List<CategoryDTO> findAllCategory() {
        return menuMapper.findAllCategory();
    }

    /*필기.
    *  @Transactional 어노테아션은 스프링 프레임워크에서 제공하는 트랜젝션 관리 지원하는 어노테이션이다
    *  트렌젝션은 데이터베이ㅔ스의 상태를 변화시키는 일(작업) 을 하나의 단위로 묶는 작업을 의미한다.
    *  데이터 조작에 관련된 작업이 일어날때 (c, u, d) 메소드 실행이 완료되면 commit,
    *  예회가 발생하게 되면 rollback  */
    @Transactional
    public void registNewMenu(MenuDTO newMenu){
        menuMapper.registNewMenu(newMenu);
    }
}
