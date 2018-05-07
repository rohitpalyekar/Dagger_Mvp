package demo.dagger_mvp.utils.rx;

import rx.Scheduler;

/**
 * Created by sony on 25-04-2018.
 */

public interface RxSchedulers {
    Scheduler runOnBackground();

    Scheduler io();

    Scheduler compute();

    Scheduler androidThread();

    Scheduler internet();

}
