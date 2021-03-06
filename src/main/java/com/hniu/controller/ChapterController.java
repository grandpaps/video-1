package com.hniu.controller;

import com.hniu.constant.StateCode;
import com.hniu.entity.Chapter;
import com.hniu.service.ChapterService;
import com.hniu.util.State;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 陈威
 */
@RestController
@RequestMapping(value = "/chapter")
public class ChapterController extends Base{

    @Resource
    private ChapterService chapterService;

    /**
     * 添加章节
     * @param chapter Chapter
     * @return map
     */
    @PostMapping(value="")
    public State<Object> insertChapter(Chapter chapter){
        int i = chapterService.insertChapter(chapter);
        if(i!=0){
            return packaging(StateCode.FAIL,"章节信息添加成功",null);
        }
        else{
            return packaging(StateCode.FAIL,"章节添加失败",null);
        }
    }
    /**
     * 修改章节
     * @param chapter Chapter
     * @return map
     */
    @PutMapping(value="")
    public State<Object> updateChapter(Chapter chapter){
        int i = chapterService.updateChapter(chapter);
        if(i!=0){
            return packaging(StateCode.FAIL,"章节修改成功",null);
        }
        else{
            return packaging(StateCode.FAIL,"章节修改失败",null);
        }
    }

    /**
     * 根据章节id删除章节信息
     * @param chapterId int
     * @return map
     */
    @DeleteMapping(value = "/{chapterId}")
    public State<Object> deleteChapterByChapterId(@PathVariable("chapterId") Integer chapterId){
        int i = chapterService.deleteChapter(chapterId);
        if(i!=0){
            return packaging(StateCode.FAIL,"章节删除成功",null);
        }
        else{
            return packaging(StateCode.FAIL,"章节删除失败",null);
        }
    }
    /**
     * 根据章节id查看章节
     * @param chapterId
     * @return
     */
    @GetMapping(value = "/{chapterId}")
    public State<Object> queryChapter(@PathVariable("chapterId") Integer chapterId){
        Chapter chapter = chapterService.queryChapter(chapterId);
        if(StringUtils.isEmpty(chapter)){
            return packaging(StateCode.FAIL,"章节查看失败",null);
        }else{
            return packaging(StateCode.SUCCESS,"章节查看成功",chapter);

        }
    }
}
