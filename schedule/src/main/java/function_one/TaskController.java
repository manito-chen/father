import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import function_one.service.TaskService;
import function_one.tast.ScheduleTask;

/**
 * @ClassName TaskController
 * @Description TODO
 * @Author 维C银翘片
 * @Date 2021/04/19  16/37
 * @Version 1.0
 * @Return
 **/

@RestController
@RequestMapping("task")
public class TaskController {
    @Autowired
    private TaskService service;
    /**     * 新增或者修改
     *     * @param id      任务ID
     * @param cron    执行时间表达式
     * @param keyword 关键字参数
     * @return true or false
     */
    @PostMapping("saveOrEdit")
    public boolean saveOrEdit(@RequestParam("id") String id, @RequestParam("cron") String cron, @RequestParam("keyword") String keyword) {
        return ScheduleUtil.reset(new ScheduleTask(id, service, keyword), cron);
    }
}
