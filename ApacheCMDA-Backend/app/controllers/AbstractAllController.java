/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import util.Common;
import org.springframework.data.repository.CrudRepository;
import com.google.gson.Gson;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * The main set of web services.
 */
@Named
@Singleton
public abstract class AbstractAllController extends Controller {

    public abstract Object getIterator();
    public abstract void printNotFound();
    public abstract String getResult(String format, Object iterator);

    public final Result getAll(String format) {
        Object iterator = getIterator();
        if (iterator == null) {
            printNotFound();
        }

        String result = new String();
        if (format.equals("json")) {
            result = getResult(format, iterator);
        }

        return ok(result);
    }
}

