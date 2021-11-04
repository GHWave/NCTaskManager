package ua.edu.sumdu.j2se.davidenko.tasks;



public class Task {

    private String title;
    private int time;
    private int start;
    private int end;
    private int interval;
    private boolean active;
    private boolean repeated;


    public Task(String title, int time) {
        boolean b;
        this.title = title;
        this.time = time;
        this.start = time;
        active=false;
        repeated=false;
    }

    public Task(String title, int start, int end, int interval) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        active=false;
        repeated=true;

    }

    public boolean isActive() {
        return active;

    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isRepeated() {
        return repeated;
    }

    public void setRepeated(boolean repeated) {
        this.repeated = repeated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTime() {
        if (isRepeated()) {
            return start;
        }
        return time;
    }

    public void setTime(int time) {
        if (isRepeated()) {
            setRepeated(false);
        }
        this.time = time;
    }

    public int getStartTime() {
        if(!isRepeated()){
            return time;
        }
        return start;
    }

    public int getEndTime() {
        if(!isRepeated()){
            return time;
        }
        return end;
    }

    public int getRepeatInterval() {
        if(!isRepeated()){
            return 0;
        }
        return interval;
    }

    public void setTime(int start, int end, int interval){
        if(!isRepeated()){

            setRepeated(true);
        }
        this.start=start;
        this.end=end;
        this.interval=interval;
    }

    public int nextTimeAfter(int current){
        for(int i= start;i<end;i+=interval){
            if(current<i){
                return i;
            }
        }
        if(!active){
            return -1;
        }
        if(current<start){
            return start;
        }

        if(current>end){
            return -1;
        }
        return -1;
    }

}

