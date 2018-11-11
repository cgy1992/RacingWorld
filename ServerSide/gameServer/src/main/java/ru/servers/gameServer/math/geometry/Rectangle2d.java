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

package ru.servers.gameServer.math.geometry;

import lombok.*;
import ru.servers.gameServer.math.algebra.Vector2d;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Rectangle2d {

    private Vector2d leftBottomPoint;
    private Vector2d leftTopPoint;
    private Vector2d rightTopPoint;
    private Vector2d rightBottomPoint;

    public double getArea(){
        double length = getLength();
        double width = getWidth();
        return length * width;
    }

    public double getPerimeter(){
        return 2 * (getWidth() + getLength());
    }

    public double getLength(){
        double firstDifference = getLengthBetweenPoints(leftTopPoint, rightTopPoint);
        double secondDifference = getLengthBetweenPoints(leftTopPoint, leftBottomPoint);
        return firstDifference > secondDifference ? firstDifference : secondDifference;
    }

    public double getDiagonalLength(){
        return Math.sqrt(getLength()*getLength() + getWidth()*getWidth());
    }

    public double getWidth(){
        double firstDifference = getLengthBetweenPoints(leftTopPoint, rightTopPoint);
        double secondDifference = getLengthBetweenPoints(leftTopPoint, leftBottomPoint);
        return firstDifference < secondDifference ? firstDifference : secondDifference;
    }

    private double getLengthBetweenPoints(Vector2d first, Vector2d second){
        double absDifferenceX = Math.abs(first.getX() - second.getX());
        double absDifferenceY = Math.abs(first.getY() - second.getY());
        return Math.sqrt(Math.abs(absDifferenceX*absDifferenceX - absDifferenceY*absDifferenceY));
    }

}