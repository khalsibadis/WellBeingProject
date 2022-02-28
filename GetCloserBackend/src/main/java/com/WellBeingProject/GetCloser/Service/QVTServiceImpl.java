package com.WellBeingProject.GetCloser.Service;

import com.WellBeingProject.GetCloser.Entity.QVT;
import com.WellBeingProject.GetCloser.Repository.QVTRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class QVTServiceImpl implements IQVTService {
    @Autowired
    QVTRepsitory qvtRepsitory;
    @Override
    public void AddQVT(QVT e) {
        qvtRepsitory.save(e);
    }

    @Override
    public List<QVT> getAllQVT() {
        return qvtRepsitory.findAll();
    }

    @Override
    public void DeleteQVT(int id) {
        qvtRepsitory.deleteById(id);
    }

    @Override
    public void UpdateQVT(QVT e) {
        qvtRepsitory.save(e);
    }
}
