package com.nikita.klimkin.testTaskJarSoft.service;

import com.nikita.klimkin.testTaskJarSoft.model.Request;
import com.nikita.klimkin.testTaskJarSoft.repository.RequestRepository;
import com.nikita.klimkin.testTaskJarSoft.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    private RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Request create(Request request) {
        ValidationUtil.isNew(request);
        return requestRepository.save(request);
    }

    public void update(Request request) {
        ValidationUtil.isUpdated(request);
        requestRepository.save(request);
    }

    public void delete(int id) {
        requestRepository.deleteById(id);
    }

    public Request get(int id) {
        return requestRepository.getOne(id);
    }

    public List<Request> getAll() {
        return requestRepository.findAll();
    }
}
