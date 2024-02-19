package com.example.shopweb.services;


import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;

@Service

public class FireBaseService {
    private Storage store = StorageOptions.getDefaultInstance().getService();

    public String save(MultipartFile multipartFile) throws Exception{
        String imageName = String.valueOf(System.currentTimeMillis());
        BlobId blobId = BlobId.of("shop-bff6b.appspot.com", imageName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).
                setContentType(multipartFile.getContentType()).build();

        store = StorageOptions.newBuilder().
                setCredentials(ServiceAccountCredentials.fromStream(new FileInputStream("shop-bff6b-firebase-adminsdk-gut62-bbbb74a0bc.json"))).
                build().getService();
        store.create(blobInfo, multipartFile.getInputStream());
        return imageName;
    }

    public String getUrl(String fileName) {
        return "https://firebasestorage.googleapis.com/v0/b/shop-bff6b.appspot.com/o/"+fileName+"?alt=media&token=3b216386-959e-436d-9ce7-fa06c449df80";
    }

}
