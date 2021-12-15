package nl.cheesydevs.minetopia.utils;

@SuppressWarnings("unused")
public class PlayerData {
    private Job job;
    private int level;
    private int fitheid;

    public PlayerData(Job job, int level, int fitheid) {
        this.job = job;
        this.level = level;
        this.fitheid = fitheid;
    }
    public PlayerData(int level, int fitheid) {
        this.job = null;
        this.level = level;
        this.fitheid = fitheid;
    }

    public void setJob(Job job) {
        this.job = job;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setFitheid(int fitheid) {
        this.fitheid = fitheid;
    }

    public Job getJob() {
        return job;
    }
    public int getLevel() {
        return level;
    }
    public int getFitheid() {
        return fitheid;
    }
}
