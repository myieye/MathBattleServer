package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Player implements Serializable, Comparable<Player> {

  private static final long serialVersionUID = -1L;

  @Id @GeneratedValue
  @Column(name="PlayerId")
  private Long              id;
  private Long              classId;
  @Column(nullable=false)
  private String            name;
  @Column(nullable=false)
  private String            username;
  private String            powerToken;
  private boolean           isTeacher;
  private int               xp;
  
  public Player() { }

  public Player(Long id, Long classId, String name, String username, String powerToken, boolean isTeacher, int xp) {
    this.id = id;
    this.classId = classId;
    this.name = name;
    this.username = username;
    this.powerToken = powerToken;
    this.isTeacher = isTeacher;
    this.xp = xp;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getClassId() {
    return classId;
  }

  public void setClassId(Long classId) {
    this.classId = classId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPowerToken() {
    return powerToken;
  }

  public void setPowerToken(String powerToken) {
    this.powerToken = powerToken;
  }

  public boolean isTeacher() {
    return isTeacher;
  }

  public void setTeacher(boolean teacher) {
    isTeacher = teacher;
  }

  public int getXp() {
    return xp;
  }

  public void setXp(int xp) {
    this.xp = xp;
  }

  public String toString() {
    return String.format("Player (%d): %s [%s], xp: %d | teacher: %b (%s)", id, name, username, xp, isTeacher, powerToken);
  }

  @Override
  public int compareTo(Player other) {
    return id.compareTo(other.getId());
  }
}
