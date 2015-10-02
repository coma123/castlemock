/*
 * Copyright 2015 Karl Dahlgren
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fortmocks.war.base.manager;

import com.google.common.base.Preconditions;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The FileManager provides functionality to upload a file to the server.
 * @author Karl Dahlgren
 * @since 1.0
 */
@Component
public class FileManager {

    @Value(value = "${temp.file.directory}")
    private String tempFilesFolder;
    private static final Logger LOGGER = Logger.getLogger(FileManager.class);

    /**
     * The method uploads a list of MultipartFiles to the server. The output file directory is configurable and can be
     * configured in the main property file under the key "temp.file.directory"
     * @param files The list of files that should be uploaded
     * @return Returns the uploaded files as a list of files. The files have the new server path.
     * @throws IOException Throws an exception if the upload fails.
     */
    public List<File> uploadFiles(final List<MultipartFile> files) throws IOException {
        final File fileDirectory = new File(tempFilesFolder);

        if (!fileDirectory.exists()) {
            fileDirectory.mkdirs();
        }

        final List<File> uploadedFiles = new ArrayList<File>();
        LOGGER.debug("Starting uploading files");
        for(MultipartFile file : files){
            LOGGER.debug("Uploading file: " + file.getOriginalFilename());
            final File serverFile = new File(fileDirectory.getAbsolutePath() + File.separator + file.getOriginalFilename());
            final byte[] bytes = file.getBytes();
            final BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            try{
                stream.write(bytes);
                uploadedFiles.add(serverFile);
            }finally {
                stream.close();
            }
        }
        return uploadedFiles;
    }

    /**
     * The method takes a list of files that has been uploaded to the server and deletes them
     * @param files The list of files that will be deleted
     */
    public void deleteUploadedFiles(final List<File> files){
        Preconditions.checkNotNull(files, "Uploaded files list cannot be null");
        LOGGER.debug("Deleting uploaded files");
        for(File file : files) {
            LOGGER.debug("Deleting: " + file.getName());
            file.delete();
        }
    }

    /**
     * The method takes a filename for a file that has been uploaded to the server and deletes them
     * @param filename The filename of the file that will be deleted
     */
    public void deleteUploadedFile(final String filename){
        Preconditions.checkNotNull(filename, "The filename cannot be null");
        final File file = new File(filename);
        if(file.exists() && file.isFile()) {
            file.delete();
        }
    }

}