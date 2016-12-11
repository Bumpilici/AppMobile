import React, { Component, PropTypes } from 'react';

import 
{
	 StyleSheet,
	 TouchableOpacity,
     TextInput,
	 Text,
     ListView,
	 View
} 
from 'react-native';

const localStyle = StyleSheet.create({

    simpleText: {
		 fontSize: 20,
		 textAlign: 'left',
	 },

     buttonText: {
		 fontSize: 20,
		 textAlign: 'center',
	 },
})

export class Location extends Component
{
    constructor()
    {
        super();

        this.state = {
            name: '',
            type: '',
            description: '',
        };
    }

    render()
    {
        return (
            <View>
                <Text style = {localStyle.simpleText}> Hello Anca! </Text>
            </View>
        );
    }
}

export class Locations extends Component
{
    constructor()
    {
        super();
    }

    allLocations()
    {
        var tmp_array = [{i: "1"}, {i: "2"}, {i: "3"}];
        return tmp_array.map
        (
            function(location, i)
            {
                return (
                    <Location key = {i}/>
                );
            }
        );
    }

    render()
    {
        return (
            <View>
                {this.allLocations()}
                <TouchableOpacity onPress = {this.props.onBack}>
					<Text style = {localStyle.buttonText}> Back </Text>
	    		</TouchableOpacity>
            </View>
        );
    }
}