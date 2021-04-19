package function_one.service;

/**
 * @ClassName TaskServiceImpl
 * @Description TODO
 * @Author 维C银翘片
 * @Date 2021/04/19  16/43
 * @Version 1.0
 * @Return
 **/
public class TaskServiceImpl implements TaskService {

    @Override
    public void work(String ketword) {
        try{
            //模拟业务逻辑
            Thread.sleep(10000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
