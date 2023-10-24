import "./DisplayTweet.css"
import { useState } from "react";

const DisplayTweet = ({tweet, currentUser}) => {

    // const [tweet, setTweet] = useState(tweet);
    const time = tweet.tweetDateTime.split("T");
    const [numberLikes, setNumberLikes] = useState(tweet.usersLikedTweet.length);

    const likeTweet = async (tweet) => {
        const newResponse = await fetch(`http://localhost:8080/tweets/likeTweet/${tweet.id}/${currentUser.id}`,{
            method: "POST",
            headers: {"Content-Type": "application/json"},
        })
        const data = await newResponse.json();
        console.log(data);
        setNumberLikes(data.usersLikedTweet.length);
    }

    const handleLikeClick = (event) => {
        event.preventDefault();
        likeTweet(tweet);
    }

    if(tweet){
        return(
            <div className="box">
                <div className="top">
                    <h4>{tweet.user.name}, {time[0]}</h4>
                    
                </div>
                <div className="middle">
                    <p>{tweet.content}</p>
                </div>
                <div className="bottom">
                    <p>{numberLikes}</p>
                    <button onClick={handleLikeClick}>Like</button>
                    <button>Comment</button>
                </div>
            </div>
        )
    } else {
        return(
            <p>No Tweet</p>
        )
    }
    

}

export default DisplayTweet;