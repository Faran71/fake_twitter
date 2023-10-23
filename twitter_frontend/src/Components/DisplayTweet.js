import "./DisplayTweet.css"
import { useState } from "react";

const DisplayTweet = ({tweet}) => {

    // const [tweet, setTweet] = useState(tweet);
    const time = tweet.tweetDateTime.split("T");
    const [numberLikes, setNumberLikes] = useState(tweet.likes);

    const likeTweet = async (tweet) => {
        const newResponse = await fetch(`http://localhost:8080/tweets/likeTweet/${tweet.id}`,{
            method: "PUT",
            headers: {"Content-Type": "application/json"},
        })
        const data = await newResponse.json();
        console.log(data);
        setNumberLikes(data.likes);
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