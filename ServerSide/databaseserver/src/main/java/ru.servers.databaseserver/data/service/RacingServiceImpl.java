/*
 * Copyright 2018 Vladimir Balun
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.servers.databaseserver.data.service;

import lombok.extern.log4j.Log4j;
import ru.servers.databaseserver.data.dao.*;
import ru.servers.protocol.gameserverwithdatabaseserver.entity.*;
import ru.servers.protocol.gameserverwithdatabaseserver.service.RacingService;

import java.util.ArrayList;
import java.util.List;

@Log4j
public class RacingServiceImpl implements RacingService {

    private RacingRepository racingRepository = new RacingRepositoryImpl();

    @Override
    public boolean addNewRacing(Racing newRacing) {
        boolean addingResult = racingRepository.save(newRacing);
        if (addingResult) {
            log.debug("New racing was added. Racing: " + newRacing.toString());
        } else {
            log.warn("Racing was not added. Racing: " + newRacing.toString());
        }
        return addingResult;
    }

    @Override
    public boolean removeRacingById(int id) {
        boolean deletingResult = racingRepository.removeById(id);
        if (deletingResult) {
            log.debug("Racing was deleted by id: " + id);
        } else {
            log.warn("Racing was not deleted by id: "  + id);
        }
        return deletingResult;
    }


    @Override
    public Racing getRacingByID(int id) {
        Racing racing = racingRepository.findById(id);
        if (racing == null){
            log.warn("Racing was not find by id. Id: " + id);
        }
        return racing;
    }

    @Override
    public List<Racing> getAllRacings() {
        ArrayList<Racing> racings = racingRepository.getAllRacings();
        if (racings == null){
            log.warn("There is no completed race");
        }
        return racings;
    }
}
